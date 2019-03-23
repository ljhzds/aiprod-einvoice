package com.asiainfo.einvoice.customized.file.interfaces;

import com.asiainfo.einvoice.core.def.InvoiceFileInfo;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;

import java.io.InputStream;

/**
 * Created by huangjh on 16/3/24.
 */
public interface IEInvoiceFileSV {
    /**
     * �ϴ��ļ�
     *
     * @param ins
     * @throws Exception
     */
    public InvoiceFileInfo upload(long eInvId, InputStream ins) throws Exception;

    /**
     * �����ļ�
     *
     * @param ins
     * @throws Exception
     */
    public InputStream download(IBOInvoicePresInstValue ins) throws Exception;
}
