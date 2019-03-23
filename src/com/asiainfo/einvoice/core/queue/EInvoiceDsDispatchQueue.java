package com.asiainfo.einvoice.core.queue;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.appframe2.complex.center.interfaces.ICenter;
import com.ai.appframe2.complex.tab.store.ICenterRegion;
import com.ai.comframe.utils.TimeUtil;
import com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITransform;
import com.asiainfo.einvoice.EInvoiceConst;
import com.asiainfo.einvoice.core.EInvoiceFactory;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDispatchBean;
import com.asiainfo.einvoice.util.DataModelUtil;
import com.asiainfo.einvoice.util.ExecuteEvent;

/**
 * 发票数据源异步处理调度队列
 */
public class EInvoiceDsDispatchQueue implements ITransform {
	private Log log = LogFactory.getLog(EInvoiceDsDispatchQueue.class);

	public void transform(HashMap[] args) throws Exception {
		// 发票开具异步处理
		if (args != null && args.length > 0) {
			for (final HashMap arg : args) {
				DataModelUtil.dependTransaction(new ExecuteEvent() {
					@Override
					public void execute() throws Exception {
						final BOInvoiceDsDispatchBean dispatch = DataModelUtil
								.convertMap2Dc(BOInvoiceDsDispatchBean.class, arg);
						try {
							if (!dispatch.getDispatchKind().equals(EInvoiceConst.DispatchKind.ASYNC_ISSUING)) {
								throw new RuntimeException("错误等调度实例分类：" + dispatch.getDispatchKind());
							}
							// 1、转化出调度对象
							long dsId = dispatch.getInvoiceDsId();
							CenterFactory.setCenterInfoByTypeAndValue("RegionId", dispatch.getSharding());
							String region = dispatch.getTargetSharding().split("_")[0];
							String billcycle = dispatch.getTargetSharding().split("_")[1];
							EInvoiceFactory.getIEInvoiceSV().issuingEInvoiceBatchDisaptch(dsId, region, billcycle);
							dispatch.setState(EInvoiceConst.DispatchState.OVER);
						} catch (Exception e) {
							log.error(e);
							dispatch.setState(EInvoiceConst.DispatchState.EXCEPTION);
						} finally {
							DataModelUtil.dependTransaction(new ExecuteEvent() {
								@Override
								public void execute() throws Exception {
									dispatch.setDispatchCount(1);
									dispatch.setExecuteTime(TimeUtil.getSysTime());
									EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDsDispatch(dispatch);
								}
							});
						}
					}
				});
			}
		}
	}

}
