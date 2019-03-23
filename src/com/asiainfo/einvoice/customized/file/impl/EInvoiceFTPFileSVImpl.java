package com.asiainfo.einvoice.customized.file.impl;

import com.asiainfo.einvoice.core.def.InvoiceFileInfo;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;
import com.asiainfo.einvoice.customized.file.interfaces.IEInvoiceFileSV;

import java.io.InputStream;

/**
 * FTP文件管理
 * <p/>
 * Created by huangjh on 16/3/25.
 */
public class EInvoiceFTPFileSVImpl implements IEInvoiceFileSV {

    @Override
    public InvoiceFileInfo upload(long eInvId, InputStream ins) throws Exception {
        return null;
    }

    @Override
    public InputStream download(IBOInvoicePresInstValue ins) throws Exception {
        return null;
    }

}
