package com.asiainfo.einvoice.customized.center;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.common.center.RegionIdCenterImpl;
import com.ai.common.util.DistrictUtil;
import com.ai.common.util.ExceptionUtil;

public class RegionIdBillCycleCenter extends RegionIdCenterImpl {
	public CenterInfo getCenterByValue(String value) throws Exception {
		if (StringUtils.isBlank(value)) {
			ExceptionUtil.throwBusinessException("BAS0000002");
		}
		String region = value.split("_")[0];
		return new CenterInfo(DistrictUtil.getCenterByRegionId(region), value);
	}
}
