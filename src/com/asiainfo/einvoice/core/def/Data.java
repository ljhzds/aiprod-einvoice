package com.asiainfo.einvoice.core.def;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by huangjh on 16/4/19.
 */
public class Data {
    @XStreamAlias("dataDescription")
    private DataDescription dataDescription;
    @XStreamAlias("content")
    private String content;

    public DataDescription getDataDescription() {
        return dataDescription;
    }

    public void setDataDescription(DataDescription dataDescription) {
        this.dataDescription = dataDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
