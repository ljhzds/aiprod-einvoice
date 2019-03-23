package com.asiainfo.einvoice.customized.message.pusher.interfaces;

import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePushTaskValue;

public interface IEInvoiceMessagePusher {
    /**
     * 电子发票推送
     *
     * @throws Exception
     */
    public void push(IBOInvoicePushTaskValue t) throws Exception;
}
