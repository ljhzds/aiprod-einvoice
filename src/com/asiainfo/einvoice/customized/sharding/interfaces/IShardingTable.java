package com.asiainfo.einvoice.customized.sharding.interfaces;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;

public interface IShardingTable {
	/**
	 * ���ݷֱ����
	 * 
	 * @param crmRequestMsg
	 * @return centerType,centerValue
	 * @throws Exception
	 */
	public String[] sharding(CrmRequestMsg crmRequestMsg) throws Exception;
}
