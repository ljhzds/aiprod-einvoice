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
 * �½��˵����ӷ�Ʊ�Զ����߽���
 *
 * @author zhanghao
 */
public class MonthlyAutoEInvoiceIssuingQueue implements ITransform {
	@Override
	public void transform(HashMap[] hashMaps) throws Exception {
		// ͨ���û��������ݻ�ȡ
		if (ArrayUtils.isEmpty(hashMaps)) {
			for (HashMap m : hashMaps) {
				final BOMonthlyAutoCustomizeBean monthly = DataModelUtil.convertMap2Dc(BOMonthlyAutoCustomizeBean.class,
						m);
				// ����������񣬲�Ӱ����������
				DataModelUtil.dependTransaction(new ExecuteEvent() {
					@Override
					public void execute() throws Exception {
						// ���Ȳ鿴�Ƿ���֮ǰ��Ϊ����Ʊ
						String mark = monthly.getPreIssuingMark();
						String[] cycle = null;
						if (StringUtils.isNotBlank(mark)) {
							// ͨ��mark����Ƿ�ѵ��·ݣ�����
							cycle = calcArrearTime(mark);
							//
						} else {
							SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
							cycle = new String[] { format.format(new Date()) };
						}
						if (!ArrayUtils.isEmpty(cycle)) {
							for (String c : cycle) {
								// ���������ã���ָ��½���÷���
								if (isArrears(monthly, c)) {
									// �����˹ܽӿڣ���ѯ�û��ķ�Ʊ��Ϣ
									CrmRequestMsg msg = EInvoiceFactory.getIAmsClientSV().queryInvoiceData(
											monthly.getCustId(), monthly.getUserId(), monthly.getAcctId(),
											monthly.getBillId(), monthly.getSharding(), c);
									EInvoiceFactory.getIEInvoiceSV().issuingEInvoiceBatch(msg, monthly.getSharding(),
											c);
								} else {
									// �����δ�����˵�����Ҫ��δ��Ʊʱ���¼�������ȴ��´ο�Ʊʱ�ж�
									if (StringUtils.isBlank(monthly.getPreIssuingMark())) {
										SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
										monthly.setPreIssuingMark(format.format(new Date()));
									}
									// ��¼δ��Ʊ����
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
		// ���������·���
		int month = cal.get(Calendar.YEAR) * 12 + cal.get(Calendar.MONTH) - (date.getYear() * 12 + date.getMonth());
		//
		String[] cycle = new String[month];
		for (int i = 0; i < month; i++) {
			cal.set(Calendar.MONTH, -1);
			cycle[i] = cal.get(Calendar.YEAR) + "" + cal.get(Calendar.MONTH);
		}
		return cycle;
	}

	// ��Ʊ֮ǰ����û��Ƿ�Ƿ�ѡ�
	private boolean isArrears(BOMonthlyAutoCustomizeBean monthly, String cycle) throws Exception {
		return EInvoiceFactory.getIAmsClientSV().isUserArrears(monthly.getCustId(), monthly.getUserId(),
				monthly.getAcctId(), monthly.getBillId(), monthly.getSharding(), cycle);
	}

}
