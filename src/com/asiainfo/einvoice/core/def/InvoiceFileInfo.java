package com.asiainfo.einvoice.core.def;

/**
 * Created by huangjh on 16/3/30.
 */
public class InvoiceFileInfo {
    //�洢����
    private String persistentType;
    //�����ʶ
    private String persistentKey;
    //�洢·��
    private String persistentPath;
    //url��ַ
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
