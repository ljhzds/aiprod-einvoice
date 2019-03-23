package com.asiainfo.einvoice.core.def;

/**
 * @author zhanghao
 */
public class CrmRequestMsg {
	private BusiMsg busiMsg;
	private InvoiceMsg invoiceMsg;
	private InvoiceItemMsg[] invoiceItemMsgs;
	private PushInfo[] pushInfos;

	public PushInfo[] getPushInfos() {
		return pushInfos;
	}

	public void setPushInfos(PushInfo[] pushInfos) {
		this.pushInfos = pushInfos;
	}

	public BusiMsg getBusiMsg() {
		return busiMsg;
	}

	public void setBusiMsg(BusiMsg busiMsg) {
		this.busiMsg = busiMsg;
	}

	public InvoiceMsg getInvoiceMsg() {
		return invoiceMsg;
	}

	public void setInvoiceMsg(InvoiceMsg invoiceMsg) {
		this.invoiceMsg = invoiceMsg;
	}

	public InvoiceItemMsg[] getInvoiceItemMsgs() {
		return invoiceItemMsgs;
	}

	public void setInvoiceItemMsgs(InvoiceItemMsg[] invoiceItemMsgs) {
		this.invoiceItemMsgs = invoiceItemMsgs;
	}

}
