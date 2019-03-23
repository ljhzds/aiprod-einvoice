package com.asiainfo.einvoice;

import com.asiainfo.einvoice.customized.check.impl.DefaultIssuingChecker;
import com.asiainfo.einvoice.customized.check.interfaces.IIssuingChecker;
import com.asiainfo.einvoice.customized.sharding.impl.DefaultShardingTable;
import com.asiainfo.einvoice.customized.sharding.interfaces.IShardingTable;

public class InstanceHelper {
	public static IShardingTable getIShardingTable() throws Exception {
		// TODO:
		return new DefaultShardingTable();
	}

	public static IIssuingChecker getIIssuingChecker() throws Exception {
		// TODO:
		return new DefaultIssuingChecker();
	}
}
