package com.asiainfo.einvoice.customized.message.builder.impl;

import com.asiainfo.einvoice.EInvoiceConst;
import com.asiainfo.einvoice.commons.template.EInvoiceTemplateProvider;
import com.asiainfo.einvoice.commons.template.impl.XmlTemplateEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.customized.message.builder.interfaces.IEInvoicePusherMsgBuilder;
import com.asiainfo.einvoice.util.EInvoiceFileHelper;

/**
 * Created by huangjh on 16/4/6.
 */
public class DefaultEInvoicePusherMsgBuilder implements IEInvoicePusherMsgBuilder {
	@Override
	public String buildPusherMsg(String pushWay, BOInvoiceDsBean dsBean, BOInvoiceDsDtlBean[] dsItemBeans,
			EInvoiceFileHelper fileHelper) throws Exception {
		if (EInvoiceConst.PushWay.EMAIL.equals(pushWay)) {
			XmlTemplateEngine engine = EInvoiceTemplateProvider.getEmail139MsgEngine();
			engine.setParams(dsBean);
			engine.setParams(dsItemBeans);
			engine.setParams("PDF", fileHelper.getEInvoiceFileString());
			return engine.render();
		} else if (EInvoiceConst.PushWay.SMS.equals(pushWay)) {
			XmlTemplateEngine engine = EInvoiceTemplateProvider.getEmail139MsgEngine();
			engine.setParams(dsBean);
			engine.setParams(dsItemBeans);
			return engine.render();
		}
		return null;
	}
}
