package com.asiainfo.einvoice.inter.ams.interfaces;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;

/**
 * boss账管系统接口本地客户端服务
 *
 * @author zhanghao
 */
public interface IAmsClientSV {
	/**
	 * 查询月结发票账单发票数据信息
	 *
	 * @param custId
	 * @param userId
	 * @param acctId
	 * @param billId
	 * @param billCycle
	 *            账期
	 * @return
	 * @throws Exception
	 */
	public CrmRequestMsg queryInvoiceData(long custId, long userId, long acctId, String billId, String region,
			String billCycle) throws Exception;

	/**
	 * 用户是否已经结清账单
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
