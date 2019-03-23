package com.asiainfo.einvoice.core.def;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by huangjh on 16/4/19.
 */

@XStreamAlias("interface")
public class SkReturnMsg {
    @XStreamAlias("globalInfo")
    private GlobalInfo globalInfo;
    @XStreamAlias("returnStateInfo")
    private ReturnStateInfo returnStateInfo;
    @XStreamAlias("Data")
    private Data data;


    public GlobalInfo getGlobalInfo() {
        return globalInfo;
    }

    public void setGlobalInfo(GlobalInfo globalInfo) {
        this.globalInfo = globalInfo;
    }

    public ReturnStateInfo getReturnStateInfo() {
        return returnStateInfo;
    }

    public void setReturnStateInfo(ReturnStateInfo returnStateInfo) {
        this.returnStateInfo = returnStateInfo;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
