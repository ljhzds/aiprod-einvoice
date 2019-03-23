package com.asiainfo.einvoice.customized.check.interfaces;

import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;

public interface IIssuingChecker {
	/**
	 * 
	 * @param ds
	 * @param dtl
	 * @return true ��ʾ��Ʊ�Ѿ����߹�
	 * @throws Exception
	 */
	public boolean beforCheck(BOInvoiceDsBean ds, BOInvoiceDsDtlBean[] dtl) throws Exception;
}
