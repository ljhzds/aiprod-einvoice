package com.asiainfo.einvoice.inter.sk.impl;

import com.asiainfo.einvoice.inter.sk.interfaces.ISkClientSV;
import com.asiainfo.einvoice.inter.sk.ws.EInvWebServiceClient;

public class ZjHxClientSVImpl implements ISkClientSV {

	public String issuingInvoice(String data) throws Exception {
		EInvWebServiceClient client = EInvWebServiceClient.getInstance();
		return client.eInvWS(data);
	}

	public String issuingInvoiceRed(String data) throws Exception {
		EInvWebServiceClient client = EInvWebServiceClient.getInstance();
		return client.eInvWS(data);
	}

	public String queryInvoice(String data) throws Exception {
		EInvWebServiceClient client = EInvWebServiceClient.getInstance();
		return client.eInvWS(data);
	}

}
