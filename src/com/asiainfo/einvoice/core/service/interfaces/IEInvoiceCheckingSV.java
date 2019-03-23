package com.asiainfo.einvoice.core.service.interfaces;

/**
 * Created by huangjh on 16/3/23.
 */
public interface IEInvoiceCheckingSV {
    /**
     * 每日开票对账
     *
     * @throws Exception
     */
    public void checking() throws Exception;
}
