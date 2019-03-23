package com.asiainfo.einvoice.inter.ams.interfaces;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;

/**
 * boss�˹�ϵͳ�ӿڱ��ؿͻ��˷���
 *
 * @author zhanghao
 */
public interface IAmsClientSV {
	/**
	 * ��ѯ�½ᷢƱ�˵���Ʊ������Ϣ
	 *
	 * @param custId
	 * @param userId
	 * @param acctId
	 * @param billId
	 * @param billCycle
	 *            ����
	 * @return
	 * @throws Exception
	 */
	public CrmRequestMsg queryInvoiceData(long custId, long userId, long acctId, String billId, String region,
			String billCycle) throws Exception;

	/**
	 * �û��Ƿ��Ѿ������˵�
	 *
	 * @param custId
	 * @param userId
	 * @param acctId
	 * @param billId
	 * @param billCycle
	 * @return
	 * @throws Exception
	 */
	public boolean isUserArrears(long custId, long userId, long acctId, String billId, String region, String billCycle)
			throws Exception;

}
