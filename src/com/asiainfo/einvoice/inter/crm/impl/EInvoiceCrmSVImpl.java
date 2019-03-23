package com.asiainfo.einvoice.inter.crm.impl;

import java.io.InputStream;
import java.util.Map;

import com.asiainfo.einvoice.core.EInvoiceFactory;
import com.asiainfo.einvoice.core.def.CrmRequestMsg;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOMonthlyAutoCustomizeValue;
import com.asiainfo.einvoice.inter.crm.interfaces.IEInvoiceCrmSV;

public class EInvoiceCrmSVImpl implements IEInvoiceCrmSV {

	public long issuingEInvoice(CrmRequestMsg messageBean, String regionId, String billCycle) throws Exception {
		return EInvoiceFactory.getIEInvoiceSV().issuingEInvoice(messageBean, regionId, billCycle);
	}

	
	public long issuingEInvoiceAsync(CrmRequestMsg messageBean, String regionId, String billCycle) throws Exception {
		return EInvoiceFactory.getIEInvoiceSV().issuingEInvoiceAsync(messageBean, regionId, billCycle);
	}


	public void issuingEInvoiceBatch(CrmRequestMsg messageBean, String regionId, String billCycle) throws Exception {
		EInvoiceFactory.getIEInvoiceSV().issuingEInvoiceBatch(messageBean, regionId, billCycle);
	}

	public long issuingEInvoiceRed(CrmRequestMsg crmRequestMsg, String regionId, String billCycle) throws Exception {
		return EInvoiceFactory.getIEInvoiceSV().issuingEInvoiceRed(crmRequestMsg, regionId, billCycle);
	}

	public InputStream downloadEInvoice(long invoiceInstId, String regionId, String billCycle) throws Exception {
		return EInvoiceFactory.getIEInvoiceSV().downloadEInvoiceInst(invoiceInstId, regionId, billCycle);
	}

	public void pushingEinvoice(long invoiceInstId, String pushWay, String pushTarget, String regionId,
			String billCycle) throws Exception {
		EInvoiceFactory.getIEInvoiceSV().pushingEinvoice(invoiceInstId, pushWay, pushTarget, regionId, billCycle);
	}

	public void fjNofity(String billId, long custId, long userId, long acctId) throws Exception {
		EInvoiceFactory.getIEInvoiceSV().fjNofity(billId, custId, userId, acctId, "");
	}

	public IBOInvoiceDsValue queryEInvoiceDs(String soOrderId, String soOrderseria, String regionId, String billCycle)
			throws Exception {
		return EInvoiceFactory.getIEInvoiceSV().queryEInvoiceDs(soOrderId, soOrderseria, regionId, billCycle);
	}

	public IBOInvoiceInstValue[] queryEInvoiceInsts(long einvoiceDsId, String regionId, String billCycle)
			throws Exception {
		return EInvoiceFactory.getIEInvoiceSV().queryEInvoiceInsts(einvoiceDsId, regionId, billCycle);
	}

	public IBOInvoiceInstValue queryEInvoiceInst(long invoiceInstId, String regionId, String billCycle)
			throws Exception {
		return EInvoiceFactory.getIEInvoiceSV().queryEInvoiceInst(invoiceInstId, regionId, billCycle);
	}

	public String[] queryEInvoiceIssuingRedReasons() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void customizedMonthlyEInvoice(Map map, String region) throws Exception {
		EInvoiceFactory.getIEInvoiceSV().monthlyAutoCustomized(map, region);
	}

	public IBOMonthlyAutoCustomizeValue queryMonthlyAutoCustomized(String billid, long custid, long userid, long acctid,
			String region) throws Exception {
		return EInvoiceFactory.getIEInvoiceSV().queryMonthlyAutoCustomized(billid, custid, userid, acctid, region);
	}

}
