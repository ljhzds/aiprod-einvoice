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
	 * 电子发票开具服务（同步开具）
	 *
	 * @param CrmRequestMsg
	 * @return
	 * @throws Exception
	 */
	public long issuingEInvoice(CrmRequestMsg CrmRequestMsg, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票开具服务（异步开具－相对税控提供的接口）
	 *
	 * @param CrmRequestMsg
	 * @throws Exception
	 */

	public long issuingEInvoiceAsync(CrmRequestMsg CrmRequestMsg, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票开具服务（批量处理）
	 *
	 * @param CrmRequestMsg
	 * @throws Exception
	 */
	public void issuingEInvoiceBatch(CrmRequestMsg CrmRequestMsg, String regionId, String billCycle) throws Exception;

	public void issuingEInvoiceBatchDisaptch(long invoiceDsId, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票冲红服务
	 *
	 * @param CrmRequestMsg
	 * @throws Exception
	 */
	public long issuingEInvoiceRed(CrmRequestMsg CrmRequestMsg, String regionId, String billCycle) throws Exception;

	/**
	 * 向税控系统请求查询服务
	 *
	 * @param inst
	 * @return
	 * @throws Exception
	 */
	public SkResponseMsg callSkQuery(BOInvoiceInstBean inst) throws Exception;

	public void callSkQueryPersistentPdf(long instId, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票推送服务（推送工单处理）
	 *
	 * @param pushTaskId
	 * @throws Exception
	 */
	public void pushingEinvoice(long pushTaskId, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票推送服务(实时推送)
	 * 
	 * @param invoiceInstId
	 * @param pushWay
	 * @param pushTarget
	 * @throws Exception
	 */
	public void pushingEinvoice(long invoiceInstId, String pushWay, String pushTarget, String regionId,
			String billCycle) throws Exception;

	/**
	 * 复机通知接口
	 * 
	 * @param billId
	 * @param custId
	 * @param userId
	 * @param acctId
	 * @throws Exception
	 */
	public void fjNofity(String billId, long custId, long userId, long acctId, String regionId) throws Exception;

	/**
	 * 月结账单自动开票定制
	 * <p/>
	 * 每月出账后，对定制了自动开具发票的客户（帐号），触发自动开票操作（通过帐管接口查询当月账单，生成异步处理的发票数据源以及调度实例，
	 * 发票调度处理时时检查当前客户是否有欠费，如果客户存在欠费挂起当前调度实例；直至用户欠费缴清后，再次自动触发发票自动开具动作，检查通过后，
	 * 置同客户之前被挂起的数据源调度实例恢复正常，开始开票处理）
	 *
	 * @throws Exception
	 */
	public void monthlyAutoCustomized(Map map, String region) throws Exception;

	public IBOMonthlyAutoCustomizeValue queryMonthlyAutoCustomized(String billid, long custid, long userid, long acctid,
			String sharding) throws Exception;

	/**
	 * 电子发票下载服务（pdf文件）
	 *
	 * @param invoiceInstId
	 *            发票实例id
	 * @throws Exception
	 */
	public InputStream downloadEInvoiceInst(long invoiceInstId, String regionId, String billCycle) throws Exception;

	/**
	 * 发票数据源查询服务
	 *
	 * @param busiType
	 *            业务类型
	 * @param conditionVal
	 *            附加查询条件（可包括2部分：a、数据源表本身字段；b、数据源表业务特征字段）
	 * @param conditionOp
	 *            附加查询条件运算（默认为＝＝、另外支持：>、>=、<、<=、!=、like、between、in）
	 * @throws Exception
	 */
	public IBOInvoiceDsValue[] queryEInvoiceDs(String busiType, Map<String, ?> conditionVal, Map<String, ?> conditionOp,
			String regionId, String billCycle) throws Exception;

	/**
	 * 发票数据源查询服务
	 * 
	 * @param soOrderId
	 *            订单编号
	 * @param soSeriaId
	 *            受理流水
	 * @param regionId
	 * @param billCycle
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceDsBean queryEInvoiceDs(String soOrderId, String soSeriaId, String regionId, String billCycle)
			throws Exception;

	/**
	 * 通过数据源ID获取电子发票数据源
	 *
	 * @param dsId
	 */
	public BOInvoiceDsBean queryEInvoiceDsByDsId(long dsId, String regionId, String billCycle) throws Exception;

	/**
	 * 通过数据源ID获取数据源详情
	 *
	 * @param dsId
	 * @return
	 * @throws Exception
	 */
	public BOInvoiceDsDtlBean[] queryEInvoiceDsDtlByDsId(long dsId, String regionId, String billCycle) throws Exception;

	/**
	 * 发票实例查询服务
	 *
	 * @param eInvoiceInstId
	 * @return
	 * @throws Exception
	 */
	public IBOInvoiceInstValue queryEInvoiceInst(long eInvoiceInstId, String regionId, String billCycle)
			throws Exception;

	/**
	 * 发票实例查询服务
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
