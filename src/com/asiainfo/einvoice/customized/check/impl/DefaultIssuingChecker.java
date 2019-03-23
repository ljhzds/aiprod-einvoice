package com.asiainfo.einvoice.customized.check.impl;

import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.customized.check.interfaces.IIssuingChecker;

public class DefaultIssuingChecker implements IIssuingChecker {

    @Override
	public boolean beforCheck(BOInvoiceDsBean ds, BOInvoiceDsDtlBean[] dtl) throws Exception {
        return false;
    }


}
