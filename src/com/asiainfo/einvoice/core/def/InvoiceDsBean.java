package com.asiainfo.einvoice.core.def;

import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceBusiFeatureBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsPushReqBean;

public class InvoiceDsBean {
	// ����Դʵ��
	private BOInvoiceDsBean invoiceDsValue;
	// ����Դʵ������
	// TODO:MISS
	// ����Դҵ������
	private BOInvoiceBusiFeatureBean[] invoiceBusiFeatureValues;
	// ����Դ��ϸʵ��
	private BOInvoiceDsDtlBean[] invoiceDsDtlValues;

	private BOInvoiceDsPushReqBean[] boInvoiceDsPushReqBeans;

	public BOInvoiceDsBean getInvoiceDsValue() {
		return invoiceDsValue;
	}

	public void setInvoiceDsValue(BOInvoiceDsBean invoiceDsValue) {
		this.invoiceDsValue = invoiceDsValue;
	}

	public BOInvoiceBusiFeatureBean[] getInvoiceBusiFeatureValues() {
		return invoiceBusiFeatureValues;
	}

	public void setInvoiceBusiFeatureValues(BOInvoiceBusiFeatureBean[] invoiceBusiFeatureValues) {
		this.invoiceBusiFeatureValues = invoiceBusiFeatureValues;
	}

	public BOInvoiceDsDtlBean[] getInvoiceDsDtlValues() {
		return invoiceDsDtlValues;
	}

	public void setInvoiceDsDtlValues(BOInvoiceDsDtlBean[] invoiceDsDtlValues) {
		this.invoiceDsDtlValues = invoiceDsDtlValues;
	}

	public BOInvoiceDsPushReqBean[] getBoInvoiceDsPushReqBeans() {
		return boInvoiceDsPushReqBeans;
	}

	public void setBoInvoiceDsPushReqBeans(BOInvoiceDsPushReqBean[] boInvoiceDsPushReqBeans) {
		this.boInvoiceDsPushReqBeans = boInvoiceDsPushReqBeans;
	}

}
