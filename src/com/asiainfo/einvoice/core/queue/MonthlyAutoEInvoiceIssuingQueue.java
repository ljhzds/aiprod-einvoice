package com.asiainfo.einvoice.core.queue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITransform;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.ArrayUtils;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.einvoice.core.EInvoiceFactory;
import com.asiainfo.einvoice.core.def.CrmRequestMsg;
import com.asiainfo.einvoice.core.def.bo.bean.BOMonthlyAutoCustomizeBean;
import com.asiainfo.einvoice.util.DataModelUtil;
import com.asiainfo.einvoice.util.ExecuteEvent;

/**
 * 月结账单电子发票自动开具进程
 *
 * @author zhanghao
 */
public class MonthlyAutoEInvoiceIssuingQueue implements ITransform {
	@Override
	public void transform(HashMap[] hashMaps) throws Exception {
		// 通过用户配置数据获取
		if (ArrayUtils.isEmpty(hashMaps)) {
			for (HashMap m : hashMaps) {
				final BOMonthlyAutoCustomizeBean monthly = DataModelUtil.convertMap2Dc(BOMonthlyAutoCustomizeBean.class,
						m);
				// 部署独立事务，不影响整个流程
				DataModelUtil.dependTransaction(new ExecuteEvent() {
					@Override
					public void execute() throws Exception {
						// 首先查看是否有之前的为开发票
						String mark = monthly.getPreIssuingMark();
						String[] cycle = null;
						if (StringUtils.isNotBlank(mark)) {
							// 通过mark计算欠费的月份，数组
							cycle = calcArrearTime(mark);
							//
						} else {
							SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
							cycle = new String[] { format.format(new Date()) };
						}
						if (!ArrayUtils.isEmpty(cycle)) {
							for (String c : cycle) {
								// 如果结清费用，则恢复月结费用发送
								if (isArrears(monthly, c)) {
									// 调用账管接口，查询用户的发票信息
									CrmRequestMsg msg = EInvoiceFactory.getIAmsClientSV().queryInvoiceData(
											monthly.getCustId(), monthly.getUserId(), monthly.getAcctId(),
											monthly.getBillId(), monthly.getSharding(), c);
									EInvoiceFactory.getIEInvoiceSV().issuingEInvoiceBatch(msg, monthly.getSharding(),
											c);
								} else {
									// 如果有未结清账单，需要将未开票时间记录下来，等待下次开票时判断
									if (StringUtils.isBlank(monthly.getPreIssuingMark())) {
										SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
										monthly.setPreIssuingMark(format.format(new Date()));
									}
									// 记录未开票年月
									EInvoiceFactory.getIEInvoiceDAO().saveMonthlyAutoCustomize(monthly);
								}
							}
						}

					}
				});

			}
		}
	}

	private String[] calcArrearTime(String mark) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date date = format.parse(mark);
		// this month
		Calendar cal = Calendar.getInstance();
		// 换算相差的月份数
		int month = cal.get(Calendar.YEAR) * 12 + cal.get(Calendar.MONTH) - (date.getYear() * 12 + date.getMonth());
		//
		String[] cycle = new String[month];
		for (int i = 0; i < month; i++) {
			cal.set(Calendar.MONTH, -1);
			cycle[i] = cal.get(Calendar.YEAR) + "" + cal.get(Calendar.MONTH);
		}
		return cycle;
	}

	// 开票之前检查用户是否欠费。
	private boolean isArrears(BOMonthlyAutoCustomizeBean monthly, String cycle) throws Exception {
		return EInvoiceFactory.getIAmsClientSV().isUserArrears(monthly.getCustId(), monthly.getUserId(),
				monthly.getAcctId(), monthly.getBillId(), monthly.getSharding(), cycle);
	}

}
