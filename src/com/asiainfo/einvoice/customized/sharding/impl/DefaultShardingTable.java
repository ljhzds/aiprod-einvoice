package com.asiainfo.einvoice.customized.sharding.impl;

import com.asiainfo.einvoice.core.def.CrmRequestMsg;
import com.asiainfo.einvoice.customized.sharding.interfaces.IShardingTable;

public class DefaultShardingTable implements IShardingTable {
	private static String REGION_ID = "regionId";
	private static String BILL_CYCLE = "billCycle";

	@Override
	public String[] sharding(CrmRequestMsg crmRequestMsg) throws Exception {
		String regionId = (String) crmRequestMsg.getBusiMsg().getFeatureMap().get(REGION_ID);
		String billCycle = (String) crmRequestMsg.getBusiMsg().getFeatureMap().get(BILL_CYCLE);
		String shardingValue = regionId + "_" + billCycle;
		return new String[] { "RegionIdBillCycle", shardingValue };
	}
}
