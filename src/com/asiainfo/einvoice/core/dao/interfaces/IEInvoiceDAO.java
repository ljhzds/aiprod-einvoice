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
	 * 通过数据源ID获取发票数据
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceDsBean getInvoiceDsById(long id, String sharding) throws Exception;

	/**
	 * 通过数据源Id获取发票数据源详情
	 *
	 * @param dsId
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceDsDtlBean[] getInvoiceDsDtlByDsId(long dsId, String sharding) throws Exception;

	/**
	 * 通过实例ID获取发票实例数据
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceInstBean getInvoiceInsById(long id, String sharding) throws Exception;

	/**
	 * 通过defId查询发票实例
	 *
	 * @param defId
	 * @throws Exception
	 */
	public IBOInvoiceInstValue[] getInvoiceInsByDefId(long defId, String sharding) throws Exception;

	/**
	 * 通过SQL查询发票业务特征
	 *
	 * @param sql
	 * @throws Exception
	 */
	public IBOInvoiceBusiFeatureValue[] getInvoiceBusiFeatureBySql(String sql, String sharding) throws Exception;

	/**
	 * 根据推送工单ID获取推送记录
	 *
	 * @throws Exception
	 */
	public IBOInvoicePushTaskValue getInvoicePusherTaskByTaskId(long pusherTaskId, String sharding) throws Exception;

	/**
	 * 通过发票实例Id获取发票文件实例
	 *
	 * @param invoiceInsId
	 * @throws Exception
	 */
	public IBOInvoicePresInstValue getInvoicePresInstByInvInsId(long invoiceInsId, String sharding) throws Exception;

	/**
	 * 通过业务类型获取定义
	 *
	 * @param busiType
	 * @return
	 * @throws Exception
	 */
	public IBOBusiFeatureRelDefValue[] getBusiFeatureRelDefByBusiType(String busiType) throws Exception;

	/**
	 * 通过用户手机号、客户ID、用户ID和账户Id查询用户月结数据
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
	 * 保存推送工单
	 *
	 * @param task
	 * @throws Exception
	 */
	public void saveInvoicePusherTask(IBOInvoicePushTaskValue task) throws Exception;

	/**
	 * 沉淀发票文件
	 *
	 * @param inst
	 * @throws Exception
	 */
	public void saveInvoicePresInst(IBOInvoicePresInstValue inst) throws Exception;

	/**
	 * 保存发票数据源
	 *
	 * @param ds
	 * @return 发票数据源ID
	 * @throws Exception
	 */
	public long saveInvoiceDs(IBOInvoiceDsValue ds) throws Exception;

	/**
	 * 保存发票数据源详情
	 *
	 * @param dtls
	 * @throws Exception
	 */
	public void saveInvoiceDsItems(IBOInvoiceDsDtlValue[] dtls) throws Exception;

	/**
	 * 保存发票业务特征
	 *
	 * @param feature
	 * @throws Exception
	 */
	public void saveInvoiceBusiFeature(IBOInvoiceBusiFeatureValue feature) throws Exception;

	/**
	 * 保存调度记录
	 *
	 * @param dispatch
	 * @throws Exception
	 */
	public void saveInvoiceDsDispatch(IBOInvoiceDsDispatchValue dispatch) throws Exception;

	/**
	 * 保存发票实例
	 *
	 * @param inst
	 * @return
	 * @throws Exception
	 */
	public long saveInvoiceInst(IBOInvoiceInstValue inst) throws Exception;

	/**
	 * 保存实例项目
	 *
	 * @param invoiceInstItem
	 * @throws Exception
	 */
	public void saveInvoiceInstItems(IBOInvoiceInstItemValue[] invoiceInstItem) throws Exception;

	/**
	 * 记录调用税控日志
	 *
	 * @param log
	 * @throws Exception
	 */
	public void saveInvoiceMsgLog(IBOInvoiceMsgLogValue log) throws Exception;

	/**
	 * 保存月结信息
	 *
	 * @param monthly
	 * @throws Exception
	 */
	public void saveMonthlyAutoCustomize(BOMonthlyAutoCustomizeBean monthly) throws Exception;

	/**
	 * 保存推送申请，推送申请只在异步开具发票时沉淀
	 *
	 * @param reqs
	 * @throws Exception
	 */
	public void saveEInvoiceDsPushReqs(BOInvoiceDsPushReqBean[] reqs) throws Exception;

	/**
	 * 物理删除记录
	 *
	 * @param dispatch
	 * @throws Exception
	 */
	public void delEInvoiceDsDispatch(BOInvoiceDsDispatchBean dispatch) throws Exception;

	public void saveInvoicePusherTaskHis(IBOInvoicePushTaskHisValue task) throws Exception;

}
