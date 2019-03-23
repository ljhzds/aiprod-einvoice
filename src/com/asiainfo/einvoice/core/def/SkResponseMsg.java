package com.asiainfo.einvoice.core.def;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 税控响应发票管理平台的消息对象
 *
 * @author zhanghao
 */
@XStreamAlias("RESPONSE_FPKJXX")
public class SkResponseMsg {
    @XStreamAlias("RETURNCODE")
    private String returnCode;
    @XStreamAlias("RETURNMESSAGE")
    private String returnMsg;
    @XStreamAlias("FP_DM")
    private String invoiceCode;//发票代码
    @XStreamAlias("CZDM")
    private String invoiceCzdm;//发票操作代码
    @XStreamAlias("FPQQLSH")
    private String invoiceQqlsh;//发票流水
    @XStreamAlias("FP_HM")
    private String invoiceNumber;//发票号码
    @XStreamAlias("KPHJSE")
    private String invoiceTax;//税金额

    private String invoicePrice;//发票税额
    @XStreamAlias("FWM")
    private String invoiceFwm;//防伪码
    @XStreamAlias("EWM")
    private String invoiceEwm;//发票二维码
    @XStreamAlias("DDH")
    private String invoiceQqddh;//订单号
    @XStreamAlias("KPRQ")
    private String issuingTime;//开票日期
    @XStreamAlias("PDF_FILE")
    private String pdfFile;//
    @XStreamAlias("FPZL_DM")
    private String invoiceTypeCode;
    @XStreamAlias("HJBHSJE")
    private String invoiceNoTaxFee;
    @XStreamAlias("PDF_URL")
    private String pdfUrl;
    @XStreamAlias("KPLX")
    private String issuingClass;

    public String getIssuingClass() {
        return issuingClass;
    }

    public void setIssuingClass(String issuingClass) {
        this.issuingClass = issuingClass;
    }

    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    public String getInvoiceNoTaxFee() {
        return invoiceNoTaxFee;
    }

    public void setInvoiceNoTaxFee(String invoiceNoTaxFee) {
        this.invoiceNoTaxFee = invoiceNoTaxFee;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

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
