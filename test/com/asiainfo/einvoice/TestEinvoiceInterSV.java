package com.asiainfo.einvoice;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.einvoice.core.service.interfaces.IEInvoiceSV;

import junit.framework.TestCase;

public class TestEinvoiceInterSV extends TestCase {
	public void testIssuingEInvoice() throws Exception {
		IEInvoiceSV service = (IEInvoiceSV) ServiceFactory.getService(IEInvoiceSV.class);
		service.printEInvoiceInst(100L);
	}
}
