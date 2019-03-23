package com.asiainfo.einvoice.core.service.interfaces;

import java.io.InputStream;
import java.util.Map;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;
import com.asiainfo.einvoice.core.def.SkResponseMsg;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsPushReqBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstBean;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOMonthlyAutoCustomizeValue;

public interface IEInvoiceSV {
	/**
	 * ���ӷ�Ʊ���߷���ͬ�����ߣ�
	 *
	 * @param CrmRequestMsg
	 * @return
	 * @throws Exception
	 */
	public long issuingEInvoice(CrmRequestMsg CrmRequestMsg, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ���߷����첽���ߣ����˰���ṩ�Ľӿڣ�
	 *
	 * @param CrmRequestMsg
	 * @throws Exception
	 */

	public long issuingEInvoiceAsync(CrmRequestMsg CrmRequestMsg, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ���߷�����������
	 *
	 * @param CrmRequestMsg
	 * @throws Exception
	 */
	public void issuingEInvoiceBatch(CrmRequestMsg CrmRequestMsg, String regionId, String billCycle) throws Exception;

	public void issuingEInvoiceBatchDisaptch(long invoiceDsId, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ������
	 *
	 * @param CrmRequestMsg
	 * @throws Exception
	 */
	public long issuingEInvoiceRed(CrmRequestMsg CrmRequestMsg, String regionId, String billCycle) throws Exception;

	/**
	 * ��˰��ϵͳ�����ѯ����
	 *
	 * @param inst
	 * @return
	 * @throws Exception
	 */
	public SkResponseMsg callSkQuery(BOInvoiceInstBean inst) throws Exception;

	public void callSkQueryPersistentPdf(long instId, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ���ͷ������͹�������
	 *
	 * @param pushTaskId
	 * @throws Exception
	 */
	public void pushingEinvoice(long pushTaskId, String regionId, String billCycle) throws Exception;

	/**
	 * ���ӷ�Ʊ���ͷ���(ʵʱ����)
	 * 
	 * @param invoiceInstId
	 * @param pushWay
	 * @param pushTarget
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
	public void fjNofity(String billId, long custId, long userId, long acctId, String regionId) throws Exception;

	/**
	 * �½��˵��Զ���Ʊ����
	 * <p/>
	 * ÿ�³��˺󣬶Զ������Զ����߷�Ʊ�Ŀͻ����ʺţ��������Զ���Ʊ������ͨ���ʹܽӿڲ�ѯ�����˵��������첽����ķ�Ʊ����Դ�Լ�����ʵ����
	 * ��Ʊ���ȴ���ʱʱ��鵱ǰ�ͻ��Ƿ���Ƿ�ѣ�����ͻ�����Ƿ�ѹ���ǰ����ʵ����ֱ���û�Ƿ�ѽ�����ٴ��Զ�������Ʊ�Զ����߶��������ͨ����
	 * ��ͬ�ͻ�֮ǰ�����������Դ����ʵ���ָ���������ʼ��Ʊ����
	 *
	 * @throws Exception
	 */
	public void monthlyAutoCustomized(Map map, String region) throws Exception;

	public IBOMonthlyAutoCustomizeValue queryMonthlyAutoCustomized(String billid, long custid, long userid, long acctid,
			String sharding) throws Exception;

	/**
	 * ���ӷ�Ʊ���ط���pdf�ļ���
	 *
	 * @param invoiceInstId
	 *            ��Ʊʵ��id
	 * @throws Exception
	 */
	public InputStream downloadEInvoiceInst(long invoiceInstId, String regionId, String billCycle) throws Exception;

	/**
	 * ��Ʊ����Դ��ѯ����
	 *
	 * @param busiType
	 *            ҵ������
	 * @param conditionVal
	 *            ���Ӳ�ѯ�������ɰ���2���֣�a������Դ�����ֶΣ�b������Դ��ҵ�������ֶΣ�
	 * @param conditionOp
	 *            ���Ӳ�ѯ�������㣨Ĭ��Ϊ����������֧�֣�>��>=��<��<=��!=��like��between��in��
	 * @throws Exception
	 */
	public IBOInvoiceDsValue[] queryEInvoiceDs(String busiType, Map<String, ?> conditionVal, Map<String, ?> conditionOp,
			String regionId, String billCycle) throws Exception;

	/**
	 * ��Ʊ����Դ��ѯ����
	 * 
	 * @param soOrderId
	 *            �������
	 * @param soSeriaId
	 *            ������ˮ
	 * @param regionId
	 * @param billCycle
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceDsBean queryEInvoiceDs(String soOrderId, String soSeriaId, String regionId, String billCycle)
			throws Exception;

	/**
	 * ͨ������ԴID��ȡ���ӷ�Ʊ����Դ
	 *
	 * @param dsId
	 */
	public BOInvoiceDsBean queryEInvoiceDsByDsId(long dsId, String regionId, String billCycle) throws Exception;

	/**
	 * ͨ������ԴID��ȡ����Դ����
	 *
	 * @param dsId
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceDsDtlBean[] queryEInvoiceDsDtlByDsId(long dsId, String regionId, String billCycle) throws Exception;

	/**
	 * ��Ʊʵ����ѯ����
	 *
	 * @param eInvoiceInstId
	 * @return
	 * @throws Exception
	 */
	public IBOInvoiceInstValue queryEInvoiceInst(long eInvoiceInstId, String regionId, String billCycle)
			throws Exception;

	/**
	 * ��Ʊʵ����ѯ����
	 *
	 * @param eInvoiceDsId
	 * @return
	 * @throws Exception
	 */
	public IBOInvoiceInstValue[] queryEInvoiceInsts(long eInvoiceDsId, String regionId, String billCycle)
			throws Exception;

	public BOInvoiceDsPushReqBean[] queryEInvoiceDsPushReqs(long dsId, String regionId, String billCycle)
			throws Exception;

}
