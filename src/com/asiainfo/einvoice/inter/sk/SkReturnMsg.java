package com.asiainfo.einvoice.inter.sk;

public class SkReturnMsg {
    private String invoiceCode;//发票代码
    private String invoiceCzdm;//发票操作代码
    private String invoiceQqlsh;//发票流水
    private String invoiceNumber;//发票号码
    private String invoiceTax;//税金额
    private String invoicePrice;//发票税额
    private String invoiceFwm;//防伪码
    private String invoiceEwm;//发票二维码
    private String invoiceQqddh;//订单号
    private String issuingTime;//开票日期
    private String pdfFile;//

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceCzdm() {
        return invoiceCzdm;
    }

    public void setInvoiceCzdm(String invoiceCzdm) {
        this.invoiceCzdm = invoiceCzdm;
    }

    public String getInvoiceQqlsh() {
        return invoiceQqlsh;
    }

    public void setInvoiceQqlsh(String invoiceQqlsh) {
        this.invoiceQqlsh = invoiceQqlsh;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceTax() {
        return invoiceTax;
    }

    public void setInvoiceTax(String invoiceTax) {
        this.invoiceTax = invoiceTax;
    }

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getInvoiceFwm() {
        return invoiceFwm;
    }

    public void setInvoiceFwm(String invoiceFwm) {
        this.invoiceFwm = invoiceFwm;
    }

    public String getInvoiceEwm() {
        return invoiceEwm;
    }

    public void setInvoiceEwm(String invoiceEwm) {
        this.invoiceEwm = invoiceEwm;
    }

    public String getInvoiceQqddh() {
        return invoiceQqddh;
    }

    public void setInvoiceQqddh(String invoiceQqddh) {
        this.invoiceQqddh = invoiceQqddh;
    }

    public String getIssuingTime() {
        return issuingTime;
    }

    public void setIssuingTime(String issuingTime) {
        this.issuingTime = issuingTime;
    }

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }
}
