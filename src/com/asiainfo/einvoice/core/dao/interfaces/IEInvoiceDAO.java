package com.asiainfo.einvoice.core.dao.interfaces;

import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDispatchBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsPushReqBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOMonthlyAutoCustomizeBean;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOBusiFeatureRelDefValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceBusiFeatureValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsDispatchValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsDtlValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstItemValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceMsgLogValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePushTaskHisValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePushTaskValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOMonthlyAutoCustomizeValue;

/**
 * Created by huangjh on 16/3/30.
 */
public interface IEInvoiceDAO {
	public BOInvoiceDsBean queryEInvoiceDs(String soOrderId, String soSeriaId, String sharding) throws Exception;

	/**
	 * ͨ������ԴID��ȡ��Ʊ����
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceDsBean getInvoiceDsById(long id, String sharding) throws Exception;

	/**
	 * ͨ������ԴId��ȡ��Ʊ����Դ����
	 *
	 * @param dsId
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceDsDtlBean[] getInvoiceDsDtlByDsId(long dsId, String sharding) throws Exception;

	/**
	 * ͨ��ʵ��ID��ȡ��Ʊʵ������
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceInstBean getInvoiceInsById(long id, String sharding) throws Exception;

	/**
	 * ͨ��defId��ѯ��Ʊʵ��
	 *
	 * @param defId
	 * @throws Exception
	 */
	public IBOInvoiceInstValue[] getInvoiceInsByDefId(long defId, String sharding) throws Exception;

	/**
	 * ͨ��SQL��ѯ��Ʊҵ������
	 *
	 * @param sql
	 * @throws Exception
	 */
	public IBOInvoiceBusiFeatureValue[] getInvoiceBusiFeatureBySql(String sql, String sharding) throws Exception;

	/**
	 * �������͹���ID��ȡ���ͼ�¼
	 *
	 * @throws Exception
	 */
	public IBOInvoicePushTaskValue getInvoicePusherTaskByTaskId(long pusherTaskId, String sharding) throws Exception;

	/**
	 * ͨ����Ʊʵ��Id��ȡ��Ʊ�ļ�ʵ��
	 *
	 * @param invoiceInsId
	 * @throws Exception
	 */
	public IBOInvoicePresInstValue getInvoicePresInstByInvInsId(long invoiceInsId, String sharding) throws Exception;

	/**
	 * ͨ��ҵ�����ͻ�ȡ����
	 *
	 * @param busiType
	 * @return
	 * @throws Exception
	 */
	public IBOBusiFeatureRelDefValue[] getBusiFeatureRelDefByBusiType(String busiType) throws Exception;

	/**
	 * ͨ���û��ֻ��š��ͻ�ID���û�ID���˻�Id��ѯ�û��½�����
	 *
	 * @param billId
	 * @param custId
	 * @param userId
	 * @param acctId
	 * @return
	 * @throws Exception
	 */
	public BOMonthlyAutoCustomizeBean getMonthlyAutoCustomize(String billId, long custId, long userId, long acctId,
			String region) throws Exception;

	public BOInvoiceDsPushReqBean[] queryEInvoiceDsPushReqs(long dsId, String sharding) throws Exception;

	/**
	 * �������͹���
	 *
	 * @param task
	 * @throws Exception
	 */
	public void saveInvoicePusherTask(IBOInvoicePushTaskValue task) throws Exception;

	/**
	 * ����Ʊ�ļ�
	 *
	 * @param inst
	 * @throws Exception
	 */
	public void saveInvoicePresInst(IBOInvoicePresInstValue inst) throws Exception;

	/**
	 * ���淢Ʊ����Դ
	 *
	 * @param ds
	 * @return ��Ʊ����ԴID
	 * @throws Exception
	 */
	public long saveInvoiceDs(IBOInvoiceDsValue ds) throws Exception;

	/**
	 * ���淢Ʊ����Դ����
	 *
	 * @param dtls
	 * @throws Exception
	 */
	public void saveInvoiceDsItems(IBOInvoiceDsDtlValue[] dtls) throws Exception;

	/**
	 * ���淢Ʊҵ������
	 *
	 * @param feature
	 * @throws Exception
	 */
	public void saveInvoiceBusiFeature(IBOInvoiceBusiFeatureValue feature) throws Exception;

	/**
	 * ������ȼ�¼
	 *
	 * @param dispatch
	 * @throws Exception
	 */
	public void saveInvoiceDsDispatch(IBOInvoiceDsDispatchValue dispatch) throws Exception;

	/**
	 * ���淢Ʊʵ��
	 *
	 * @param inst
	 * @return
	 * @throws Exception
	 */
	public long saveInvoiceInst(IBOInvoiceInstValue inst) throws Exception;

	/**
	 * ����ʵ����Ŀ
	 *
	 * @param invoiceInstItem
	 * @throws Exception
	 */
	public void saveInvoiceInstItems(IBOInvoiceInstItemValue[] invoiceInstItem) throws Exception;

	/**
	 * ��¼����˰����־
	 *
	 * @param log
	 * @throws Exception
	 */
	public void saveInvoiceMsgLog(IBOInvoiceMsgLogValue log) throws Exception;

	/**
	 * �����½���Ϣ
	 *
	 * @param monthly
	 * @throws Exception
	 */
	public void saveMonthlyAutoCustomize(BOMonthlyAutoCustomizeBean monthly) throws Exception;

	/**
	 * �����������룬��������ֻ���첽���߷�Ʊʱ����
	 *
	 * @param reqs
	 * @throws Exception
	 */
	public void saveEInvoiceDsPushReqs(BOInvoiceDsPushReqBean[] reqs) throws Exception;

	/**
	 * ����ɾ����¼
	 *
	 * @param dispatch
	 * @throws Exception
	 */
	public void delEInvoiceDsDispatch(BOInvoiceDsDispatchBean dispatch) throws Exception;

	public void saveInvoicePusherTaskHis(IBOInvoicePushTaskHisValue task) throws Exception;

}
