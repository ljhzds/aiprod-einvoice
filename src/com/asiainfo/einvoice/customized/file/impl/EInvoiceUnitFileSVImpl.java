package com.asiainfo.einvoice.customized.file.impl;

import com.asiainfo.einvoice.core.def.InvoiceFileInfo;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;
import com.asiainfo.einvoice.customized.file.interfaces.IEInvoiceFileSV;
import com.asiainfo.einvoice.inter.file.impl.UnitFileClient;
import com.asiainfo.einvoice.inter.file.interfaces.IFileClient;

import java.io.InputStream;

/**
 * 统一内容管理平台文件管理
 * <p/>
 * Created by huangjh on 16/3/24.
 */
public class EInvoiceUnitFileSVImpl implements IEInvoiceFileSV {
    @Override
    public InvoiceFileInfo upload(long eInvId, InputStream ins) throws Exception {
        IFileClient client = new UnitFileClient();
        return (InvoiceFileInfo) client.uploadFile(ins, eInvId);
    }

    @Override
    public InputStream download(IBOInvoicePresInstValue ins) throws Exception {
        IFileClient client = new UnitFileClient();
        return client.downloadFile(ins);
    }


}
