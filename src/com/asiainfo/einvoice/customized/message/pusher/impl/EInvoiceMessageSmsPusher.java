package com.asiainfo.einvoice.customized.message.pusher.impl;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.einvoice.commons.template.EInvoiceTemplateProvider;
import com.asiainfo.einvoice.commons.template.impl.XmlTemplateEngine;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePushTaskValue;
import com.asiainfo.einvoice.customized.message.pusher.interfaces.IEInvoiceMessagePusher;

public class EInvoiceMessageSmsPusher implements IEInvoiceMessagePusher {

    @Override
    public void push(IBOInvoicePushTaskValue t) throws Exception {
        String content = t.getPushContent();
        if (StringUtils.isNotBlank(content)) {
        }
    }
}
