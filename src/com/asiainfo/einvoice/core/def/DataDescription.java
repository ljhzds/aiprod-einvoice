package com.asiainfo.einvoice.core.def;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by huangjh on 16/4/19.
 */
public class DataDescription {
    @XStreamAlias("zipCode")
    private String zipCode;
    @XStreamAlias("encryptCode")
    private String encryptCode;
    @XStreamAlias("codeType")
    private String codeType;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEncryptCode() {
        return encryptCode;
    }

    public void setEncryptCode(String encryptCode) {
        this.encryptCode = encryptCode;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
}
