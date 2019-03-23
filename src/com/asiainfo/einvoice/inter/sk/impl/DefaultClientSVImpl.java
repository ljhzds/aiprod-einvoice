package com.asiainfo.einvoice.inter.sk.impl;

import com.asiainfo.einvoice.inter.sk.interfaces.ISkClientSV;
import com.asiainfo.einvoice.util.DataModelUtil;

import java.io.*;

public class DefaultClientSVImpl implements ISkClientSV {

    @Override
    public String issuingInvoice(String data) throws Exception {
        InputStream ins = DefaultClientSVImpl.class.getResourceAsStream("openReaponse.xml");
        StringWriter writer = new StringWriter();
        int i;
        while ((i = ins.read()) != -1) {
            writer.write(i);
        }
        return writer.toString();
    }

    @Override
    public String issuingInvoiceRed(String data) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String queryInvoice(String data) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
