package com.asiainfo.einvoice.core.def;

/**
 * Created by huangjh on 16/4/6.
 */
public class EInvoicePushInfo {

    private String sendType;// 0 不推送 1 推送（短信+邮件） 2 仅短信推送 3 仅邮件推送（PDF文件）
    private String email;
    private String billId;

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }
}
