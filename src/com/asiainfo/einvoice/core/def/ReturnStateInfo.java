package com.asiainfo.einvoice.core.def;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by huangjh on 16/4/19.
 */

public class ReturnStateInfo {
    @XStreamAlias("returnCode")
    private String returnCode;
    @XStreamAlias("returnMessage")
    private String returnMessage;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
