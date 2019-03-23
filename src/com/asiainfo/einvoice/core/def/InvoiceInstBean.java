package com.asiainfo.einvoice.core.def;


import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstItemValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePushTaskValue;

public class InvoiceInstBean {
	private IBOInvoiceInstValue invoiceInstValue;
	private IBOInvoiceInstItemValue[] iboInvoiceInstItemValues;
	private IBOInvoicePushTaskValue[] iboInvoicePushTaskValues;
	private IBOInvoicePresInstValue invoicePresInstValue;

	public IBOInvoiceInstValue getInvoiceInstValue() {
		return invoiceInstValue;
	}

	public void setInvoiceInstValue(IBOInvoiceInstValue invoiceInstValue) {
		this.invoiceInstValue = invoiceInstValue;
	}

	public IBOInvoiceInstItemValue[] getIboInvoiceInstItemValues() {
		return iboInvoiceInstItemValues;
	}

	public void setIboInvoiceInstItemValues(IBOInvoiceInstItemValue[] iboInvoiceInstItemValues) {
		this.iboInvoiceInstItemValues = iboInvoiceInstItemValues;
	}

	public IBOInvoicePushTaskValue[] getIboInvoicePushTaskValues() {
		return iboInvoicePushTaskValues;
	}

	public void setIboInvoicePushTaskValues(IBOInvoicePushTaskValue[] iboInvoicePushTaskValues) {
		this.iboInvoicePushTaskValues = iboInvoicePushTaskValues;
	}

	public IBOInvoicePresInstValue getInvoicePresInstValue() {
		return invoicePresInstValue;
	}

	public void setInvoicePresInstValue(IBOInvoicePresInstValue invoicePresInstValue) {
		this.invoicePresInstValue = invoicePresInstValue;
	}

}
