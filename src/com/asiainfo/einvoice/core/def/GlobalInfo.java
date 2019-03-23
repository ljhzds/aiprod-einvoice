package com.asiainfo.einvoice.core.def;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by huangjh on 16/4/19.
 */
public class GlobalInfo {
    @XStreamAlias("terminalCode")
    private String terminalCode;
    @XStreamAlias("appId")
    private String appId;
    @XStreamAlias("version")
    private String version;
    @XStreamAlias("interfaceCode")
    private String interfaceCode;
    @XStreamAlias("userName")
    private String userName;
    @XStreamAlias("passWord")
    private String passWord;
    @XStreamAlias("taxpayerId")
    private String taxpayerId;
    @XStreamAlias("authorizationCode")
    private String authorizationCode;
    @XStreamAlias("requestCode")
    private String requestCode;
    @XStreamAlias("requestTime")
    private String requestTime;
    @XStreamAlias("responseCode")
    private String responseCode;
    @XStreamAlias("dataExchangeId")
    private String dataExchangeId;

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDataExchangeId() {
        return dataExchangeId;
    }

    public void setDataExchangeId(String dataExchangeId) {
        this.dataExchangeId = dataExchangeId;
    }
}
