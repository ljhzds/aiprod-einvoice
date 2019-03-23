package com.asiainfo.einvoice.inter.crm.interfaces;

import java.io.InputStream;
import java.util.Map;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOMonthlyAutoCustomizeValue;

/**
 * 发票平台对CRM系统提供的服务接口
 * 
 * @author zhanghao
 *
 */
public interface IEInvoiceCrmSV {

	// public long issuingEInvoice(String busiType, Object... requestObject)；

	/**
	 * 电子发票开具服务（同步）
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public long issuingEInvoice(CrmRequestMsg msg, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票开具服务（异步）
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public long issuingEInvoiceAsync(CrmRequestMsg msg, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票开具服务（批量）
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public void issuingEInvoiceBatch(CrmRequestMsg msg, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票冲红服务
	 * 
	 * 根据发票开具ID对原开具的发票进行冲红操作
	 * 
	 * @param msg
	 * @return 发票冲红记录ID
	 * @throws Exception
	 */
	public long issuingEInvoiceRed(CrmRequestMsg msg, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票下载服务:对已经开具的电子发票，从存储系统提并提供的PDF文件下载服务
	 * 
	 * @param invoiceInstId
	 *            电子发票实例id
	 * @param sharding
	 *            分表标志
	 * @return
	 * @throws Exception
	 */
	public InputStream downloadEInvoice(long invoiceInstId, String regionId, String billCycle) throws Exception;

	/**
	 * 电子发票推送服务
	 * 
	 * @param invoiceInstId
	 *            电子发票实例id
	 * @param pushWay
	 *            推送方式
	 * @param pushTarget
	 *            推送目标
	 * @param sharding
	 *            分表标志
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
	public void fjNofity(String billId, long custId, long userId, long acctId) throws Exception;

	public IBOInvoiceDsValue queryEInvoiceDs(String soOrderId, String soOrderseria, String regionId, String billCycle)
			throws Exception;

	/**
	 * 电子发票开具记录查询服务（电子根据发票数据源信息）
	 * 
	 * @param invoiceData
	 * @return
	 * @throws Exception
	 */
	public IBOInvoiceInstValue[] queryEInvoiceInsts(long invoiceDsId, String regionId, String billCycler)
			throws Exception;

	/**
	 * 电子发票开具记录查询服务
	 * 
	 * @param eInvoiceIssuingId
	 *            电子发票开具记录Id
	 * @return
	 * @throws Exception
	 */
	public IBOInvoiceInstValue queryEInvoiceInst(long invoiceInstId, String regionId, String billCycle)
			throws Exception;

	/**
	 * 电子发票冲红原因查询服务（可选冲红配置列表）
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] queryEInvoiceIssuingRedReasons() throws Exception;

	public IBOMonthlyAutoCustomizeValue queryMonthlyAutoCustomized(String billid, long custid, long userid, long acctid,
			String region) throws Exception;

	/**
	 * 月结账单电子发票定制服务
	 * 
	 * @throws Exception
	 */
	public void customizedMonthlyEInvoice(Map map, String region) throws Exception;

}
