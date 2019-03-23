package com.asiainfo.einvoice.core.def;

/**
 * Created by huangjh on 16/3/30.
 */
public class InvoiceFileInfo {
    //存储类型
    private String persistentType;
    //储存标识
    private String persistentKey;
    //存储路径
    private String persistentPath;
    //url地址
    private String url;

    public String getPersistentType() {
        return persistentType;
    }

    public void setPersistentType(String persistentType) {
        this.persistentType = persistentType;
    }

    public String getPersistentKey() {
        return persistentKey;
    }

    public void setPersistentKey(String persistentKey) {
        this.persistentKey = persistentKey;
    }

    public String getPersistentPath() {
        return persistentPath;
    }

    public void setPersistentPath(String persistentPath) {
        this.persistentPath = persistentPath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
