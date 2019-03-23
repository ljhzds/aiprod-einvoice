package com.asiainfo.einvoice.customized.check.interfaces;

import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;

public interface IIssuingChecker {
	/**
	 * 
	 * @param ds
	 * @param dtl
	 * @return true 表示发票已经开具过
	 * @throws Exception
	 */
	public boolean beforCheck(BOInvoiceDsBean ds, BOInvoiceDsDtlBean[] dtl) throws Exception;
}
