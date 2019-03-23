package com.asiainfo.einvoice.customized.message.builder.interfaces;

import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.util.EInvoiceFileHelper;

/**
 * Created by huangjh on 16/3/30.
 */
public interface IEInvoicePusherMsgBuilder {
	/**
	 * ÍÆËÍÏûÏ¢
	 *
	 * @param dsBean
	 * @param dsItemBeans
	 * @param fileHelper
	 * @return
	 * @throws Exception
	 */
	public String buildPusherMsg(String pushWay, BOInvoiceDsBean dsBean, BOInvoiceDsDtlBean[] dsItemBeans,
			EInvoiceFileHelper fileHelper) throws Exception;
}
