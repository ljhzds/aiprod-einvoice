package com.asiainfo.einvoice.inter.crm.interfaces;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;

public interface IEInvoiceCrmClientSV {

	/**
	 * 纸质发票是否开具查询接口
	 * 
	 * @param requestMsgBean
	 *            电子发票模块标准发票开具请求对象
	 * @return true－开具；false－未开具；
	 * @throws Exception
	 */
	public boolean isPaperInvoiceIssuing(CrmRequestMsg requestMsgBean) throws Exception;

	/**
	 * 客户（＊）是否欠费查询接口
	 * 
	 * @param custId
	 *            客户ID
	 * @param userId
	 *            用户ID
	 * @param acctId
	 *            账户ID
	 * @param billId
	 *            计费号码
	 * @return
	 * @throws Exception
	 */
	public boolean isCustomAccountArrears(long custId, long userId, long acctId, String billId) throws Exception;
}
