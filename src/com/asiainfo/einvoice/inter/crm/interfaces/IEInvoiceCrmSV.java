package com.asiainfo.einvoice.inter.crm.interfaces;

import java.io.InputStream;
import java.util.Map;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOMonthlyAutoCustomizeValue;

/**
 * ��Ʊƽ̨��CRMϵͳ�ṩ�ķ���ӿ�
 * 
 * @author zhanghao
 *
 */
public interface IEInvoiceCrmSV {

	// public long issuingEInvoice(String busiType, Object... requestObject)��

	/**
	 * ���ӷ�Ʊ���߷���ͬ����
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public long issuingEInvoice(CrmRequestMsg msg, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ���߷����첽��
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public long issuingEInvoiceAsync(CrmRequestMsg msg, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ���߷���������
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public void issuingEInvoiceBatch(CrmRequestMsg msg, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ������
	 * 
	 * ���ݷ�Ʊ����ID��ԭ���ߵķ�Ʊ���г�����
	 * 
	 * @param msg
	 * @return ��Ʊ����¼ID
	 * @throws Exception
	 */
	public long issuingEInvoiceRed(CrmRequestMsg msg, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ���ط���:���Ѿ����ߵĵ��ӷ�Ʊ���Ӵ洢ϵͳ�Ტ�ṩ��PDF�ļ����ط���
	 * 
	 * @param invoiceInstId
	 *            ���ӷ�Ʊʵ��id
	 * @param sharding
	 *            �ֱ��־
	 * @return
	 * @throws Exception
	 */
	public InputStream downloadEInvoice(long invoiceInstId, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ���ͷ���
	 * 
	 * @param invoiceInstId
	 *            ���ӷ�Ʊʵ��id
	 * @param pushWay
	 *            ���ͷ�ʽ
	 * @param pushTarget
	 *            ����Ŀ��
	 * @param sharding
	 *            �ֱ��־
	 * @throws Exception
	 */
	public void pushingEinvoice(long invoiceInstId, String pushWay, String pushTarget, String regionId,
			String billCycle) throws Exception;

	/**
	 * ����֪ͨ�ӿ�
	 * 
	 * @param billId
	 * @param custId
	 * @param userId
	 * @param acctId
	 * @throws Exception
	 */
	public void fjNofity(String billId, long custId, long userId, long acctId) throws Exception;

	public IBOInvoiceDsValue queryEInvoiceDs(String soOrderId, String soOrderseria, String regionId, String billCycle)
			throws Exception;

	/**
	 * ���ӷ�Ʊ���߼�¼��ѯ���񣨵��Ӹ��ݷ�Ʊ����Դ��Ϣ��
	 * 
	 * @param invoiceData
	 * @return
	 * @throws Exception
	 */
	public IBOInvoiceInstValue[] queryEInvoiceInsts(long invoiceDsId, String regionId, String billCycler)
			throws Exception;

	/**
	 * ���ӷ�Ʊ���߼�¼��ѯ����
	 * 
	 * @param eInvoiceIssuingId
	 *            ���ӷ�Ʊ���߼�¼Id
	 * @return
	 * @throws Exception
	 */
	public IBOInvoiceInstValue queryEInvoiceInst(long invoiceInstId, String regionId, String billCycle)
			throws Exception;

	/**
	 * ���ӷ�Ʊ���ԭ���ѯ���񣨿�ѡ��������б�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] queryEInvoiceIssuingRedReasons() throws Exception;

	public IBOMonthlyAutoCustomizeValue queryMonthlyAutoCustomized(String billid, long custid, long userid, long acctid,
			String region) throws Exception;

	/**
	 * �½��˵����ӷ�Ʊ���Ʒ���
	 * 
	 * @throws Exception
	 */
	public void customizedMonthlyEInvoice(Map map, String region) throws Exception;

}
