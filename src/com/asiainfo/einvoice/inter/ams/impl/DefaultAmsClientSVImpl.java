package com.asiainfo.einvoice.inter.ams.impl;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;
import com.asiainfo.einvoice.inter.ams.interfaces.IAmsClientSV;

/**
 * Created by huangjh on 16/4/12.
 */
public class DefaultAmsClientSVImpl implements IAmsClientSV {

	public CrmRequestMsg queryInvoiceData(long custId, long userId, long acctId, String billId, String region,
			String billCycle) throws Exception {
		return null;
	}

	public boolean isUserArrears(long custId, long userId, long acctId, String billId, String region, String billCycle)
			throws Exception {
		return false;
	}
}
