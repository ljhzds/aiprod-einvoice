package com.asiainfo.einvoice.core.def;

import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceBusiFeatureBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsPushReqBean;

public class InvoiceDsBean {
	// 数据源实例
	private BOInvoiceDsBean invoiceDsValue;
	// 数据源实例属性
	// TODO:MISS
	// 数据源业务特征
	private BOInvoiceBusiFeatureBean[] invoiceBusiFeatureValues;
	// 数据源明细实例
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
