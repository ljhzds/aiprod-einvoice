package com.asiainfo.einvoice.core.def;

/**
 * Created by huangjh on 16/4/8.
 */
public class PushInfo {
    /**
     * public final static  String S_Notes = "NOTES";
     * public final static  String S_Ext3 = "EXT3";
     * public final static  String S_Ext4 = "EXT4";
     * public final static  String S_Ext5 = "EXT5";
     * public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
     * public final static  String S_Sharding = "SHARDING";
     * public final static  String S_PushTarget = "PUSH_TARGET";
     * public final static  String S_Remarks = "REMARKS";
     * public final static  String S_PushReqId = "PUSH_REQ_ID";
     * public final static  String S_PushWay = "PUSH_WAY";
     */
    // 0 不推送 1 推送（短信+邮件） 2 仅短信推送 3 仅邮件推送（PDF文件）
    private String pushTarget;
    private String pushWay;

    public String getPushTarget() {
        return pushTarget;
    }

    public void setPushTarget(String pushTarget) {
        this.pushTarget = pushTarget;
    }

    public String getPushWay() {
        return pushWay;
    }

    public void setPushWay(String pushWay) {
        this.pushWay = pushWay;
    }
}
