package com.asiainfo.einvoice.inter.crm.interfaces;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;

public interface IEInvoiceCrmClientSV {

	/**
	 * ֽ�ʷ�Ʊ�Ƿ񿪾߲�ѯ�ӿ�
	 * 
	 * @param requestMsgBean
	 *            ���ӷ�Ʊģ���׼��Ʊ�����������
	 * @return true�����ߣ�false��δ���ߣ�
	 * @throws Exception
	 */
	public boolean isPaperInvoiceIssuing(CrmRequestMsg requestMsgBean) throws Exception;

	/**
	 * �ͻ��������Ƿ�Ƿ�Ѳ�ѯ�ӿ�
	 * 
	 * @param custId
	 *            �ͻ�ID
	 * @param userId
	 *            �û�ID
	 * @param acctId
	 *            �˻�ID
	 * @param billId
	 *            �ƷѺ���
	 * @return
	 * @throws Exception
	 */
	public boolean isCustomAccountArrears(long custId, long userId, long acctId, String billId) throws Exception;
}
