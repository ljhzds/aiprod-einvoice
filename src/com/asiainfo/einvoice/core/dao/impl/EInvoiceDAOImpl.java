package com.asiainfo.einvoice.core.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ai.appframe2.complex.tab.split.SplitTableFactory;
import com.ai.appframe2.complex.tab.split.TableVars;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.comframe.utils.TimeUtil;
import com.ai.comframe.vm.common.Constant;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.ArrayUtils;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.einvoice.EInvoiceConst;
import com.asiainfo.einvoice.core.dao.interfaces.IEInvoiceDAO;
import com.asiainfo.einvoice.core.def.bo.bean.BOBusiFeatureRelDefEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceBusiFeatureBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceBusiFeatureEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDispatchBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDispatchEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsPushReqBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsPushReqEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstItemEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceMsgLogEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoicePresInstBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoicePresInstEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoicePushTaskBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoicePushTaskEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoicePushTaskHisEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOMonthlyAutoCustomizeBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOMonthlyAutoCustomizeEngine;
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

import oracle.net.aso.p;

/**
 * Created by huangjh on 16/4/2.
 */
public class EInvoiceDAOImpl implements IEInvoiceDAO {
	private Logger logger = Logger.getLogger(EInvoiceDAOImpl.class);

	public BOInvoiceDsBean queryEInvoiceDs(String soOrderId, String soSeriaCode, String sharding) throws Exception {
		String table = BOInvoiceDsBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");

		StringBuffer boSql = new StringBuffer();
		boSql.append(" select * from ").append("{").append(table).append("}");
		boSql.append(" where 1=1 ");
		Map paramMap = new HashMap();
		if (!StringUtils.isBlank(soOrderId)) {
			boSql.append(" and ").append(BOInvoiceDsBean.S_SoOrderId).append(" = :")
					.append(BOInvoiceDsBean.S_SoOrderId);
			paramMap.put(BOInvoiceDsBean.S_SoOrderId, soOrderId);
		}
		if (!StringUtils.isBlank(soSeriaCode)) {
			boSql.append(" and ").append(BOInvoiceDsBean.S_SoOrderSeria).append(" = :")
					.append(BOInvoiceDsBean.S_SoOrderSeria);
			paramMap.put(BOInvoiceDsBean.S_SoOrderSeria, soSeriaCode);
		}

		TableVars objTableVars = new TableVars();
		objTableVars.add(table, "SHARDING", sharding);
		String excuSql = SplitTableFactory.createQuerySQL(boSql.toString(), objTableVars);
		BOInvoiceDsBean[] values = BOInvoiceDsEngine.getBeansFromSql(excuSql, paramMap);
		return values != null && values.length > 0 ? values[0] : null;
	}

	@Override
	public BOInvoiceDsBean getInvoiceDsById(long id, String sharding) throws Exception {
		String table = BOInvoiceDsBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");

		StringBuffer boSql = new StringBuffer();
		boSql.append(" select * from ").append("{").append(table).append("}");
		boSql.append(" where ").append(BOInvoiceDsBean.S_InvoiceDsId).append(" = :")
				.append(BOInvoiceDsBean.S_InvoiceDsId);

		Map paramMap = new HashMap();
		paramMap.put(BOInvoiceDsBean.S_InvoiceDsId, id);
		TableVars objTableVars = new TableVars();
		objTableVars.add(table, "SHARDING", sharding);
		String excuSql = SplitTableFactory.createQuerySQL(boSql.toString(), objTableVars);
		BOInvoiceDsBean[] values = BOInvoiceDsEngine.getBeansFromSql(excuSql, paramMap);
		return values != null && values.length > 0 ? values[0] : null;
	}

	@Override
	public BOInvoiceDsDtlBean[] getInvoiceDsDtlByDsId(long dsId, String sharding) throws Exception {
		String table = BOInvoiceDsDtlBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");

		StringBuffer boSql = new StringBuffer();
		boSql.append(" select * from ").append("{").append(table).append("}");
		boSql.append(" where ").append(BOInvoiceDsDtlBean.S_InvoiceDsId).append(" = :")
				.append(BOInvoiceDsDtlBean.S_InvoiceDsId);

		Map paramMap = new HashMap();
		paramMap.put(BOInvoiceDsDtlBean.S_InvoiceDsId, dsId);
		TableVars objTableVars = new TableVars();
		objTableVars.add(table, "SHARDING", sharding);
		String excuSql = SplitTableFactory.createQuerySQL(boSql.toString(), objTableVars);
		return BOInvoiceDsDtlEngine.getBeansFromSql(excuSql, paramMap);
	}

	public BOInvoiceDsPushReqBean[] queryEInvoiceDsPushReqs(long dsId, String sharding) throws Exception {
		String table = BOInvoiceDsPushReqBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");

		StringBuffer boSql = new StringBuffer();
		boSql.append(" select * from ").append("{").append(table).append("}");
		boSql.append(" where ").append(BOInvoiceDsPushReqBean.S_InvoiceDsId).append(" = :")
				.append(BOInvoiceDsPushReqBean.S_InvoiceDsId);

		Map paramMap = new HashMap();
		paramMap.put(BOInvoiceDsPushReqBean.S_InvoiceDsId, dsId);
		TableVars objTableVars = new TableVars();
		objTableVars.add(table, "SHARDING", sharding);
		String excuSql = SplitTableFactory.createQuerySQL(boSql.toString(), objTableVars);
		return BOInvoiceDsPushReqEngine.getBeansFromSql(excuSql, paramMap);
	}

	@Override
	public IBOInvoiceInstValue[] getInvoiceInsByDefId(long dsId, String sharding) throws Exception {
		String table = BOInvoiceInstBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");

		StringBuffer boSql = new StringBuffer();
		boSql.append(" select * from ").append("{").append(table).append("}");
		boSql.append(" where ").append(BOInvoiceInstBean.S_InvoiceDsId).append(" = :")
				.append(BOInvoiceInstBean.S_InvoiceDsId);

		Map paramMap = new HashMap();
		paramMap.put(BOInvoiceInstBean.S_InvoiceDsId, dsId);
		TableVars objTableVars = new TableVars();
		objTableVars.add(table, "SHARDING", sharding);
		String excuSql = SplitTableFactory.createQuerySQL(boSql.toString(), objTableVars);
		return BOInvoiceInstEngine.getBeansFromSql(excuSql, paramMap);
	}

	@Override
	public BOInvoiceInstBean getInvoiceInsById(long id, String sharding) throws Exception {
		String table = BOInvoiceInstBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");

		StringBuffer boSql = new StringBuffer();
		boSql.append(" select * from ").append("{").append(table).append("}");
		boSql.append(" where ").append(BOInvoiceInstBean.S_InvoiceInstanceId).append(" = :")
				.append(BOInvoiceInstBean.S_InvoiceInstanceId);

		Map paramMap = new HashMap();
		paramMap.put(BOInvoiceInstBean.S_InvoiceInstanceId, id);
		TableVars objTableVars = new TableVars();
		objTableVars.add(table, "SHARDING", sharding);
		String excuSql = SplitTableFactory.createQuerySQL(boSql.toString(), objTableVars);
		BOInvoiceInstBean[] values = BOInvoiceInstEngine.getBeansFromSql(excuSql, paramMap);
		return values != null && values.length > 0 ? values[0] : null;
	}

	@Override
	public IBOInvoicePushTaskValue getInvoicePusherTaskByTaskId(long pusherTaskId, String sharding) throws Exception {
		String table = BOInvoicePushTaskBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");

		StringBuffer boSql = new StringBuffer();
		boSql.append(" select * from ").append("{").append(table).append("}");
		boSql.append(" where ").append(BOInvoicePushTaskBean.S_PushTaskId).append(" = :")
				.append(BOInvoicePushTaskBean.S_PushTaskId);
		Map paramMap = new HashMap();
		paramMap.put(BOInvoicePushTaskBean.S_PushTaskId, pusherTaskId);
		TableVars objTableVars = new TableVars();
		objTableVars.add(table, "SHARDING", sharding);
		String excuSql = SplitTableFactory.createQuerySQL(boSql.toString(), objTableVars);
		IBOInvoicePushTaskValue[] values = BOInvoicePushTaskEngine.getBeansFromSql(excuSql, paramMap);
		return values != null && values.length > 0 ? values[0] : null;
	}

	@Override
	public IBOInvoicePresInstValue getInvoicePresInstByInvInsId(long invoiceInsId, String sharding) throws Exception {
		String table = BOInvoicePresInstBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");

		StringBuffer boSql = new StringBuffer();
		boSql.append(" select * from ").append("{").append(table).append("}");
		boSql.append(" where ").append(BOInvoicePresInstBean.S_InvoiceInstanceId).append(" = :")
				.append(BOInvoicePresInstBean.S_InvoiceInstanceId);
		Map paramMap = new HashMap();
		paramMap.put(BOInvoicePresInstBean.S_InvoiceInstanceId, invoiceInsId);
		TableVars objTableVars = new TableVars();
		objTableVars.add(table, "SHARDING", sharding);
		String excuSql = SplitTableFactory.createQuerySQL(boSql.toString(), objTableVars);
		IBOInvoicePresInstValue[] values = BOInvoicePresInstEngine.getBeansFromSql(excuSql, paramMap);
		return values != null && values.length > 0 ? values[0] : null;
	}

	@Override
	public IBOBusiFeatureRelDefValue[] getBusiFeatureRelDefByBusiType(String busiType) throws Exception {
		Criteria sql = new Criteria();
		sql.addEqual(IBOBusiFeatureRelDefValue.S_BusiType, busiType);
		sql.addEqual(IBOBusiFeatureRelDefValue.S_State, Constant.CommonState.VALIDATION);
		return BOBusiFeatureRelDefEngine.getBeans(sql);
	}

	@Override
	public IBOInvoiceBusiFeatureValue[] getInvoiceBusiFeatureBySql(String sql, String sharding) throws Exception {
		TableVars objTableVars = new TableVars();
		String table = BOInvoiceBusiFeatureBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");
		objTableVars.add(table, IBOInvoiceBusiFeatureValue.S_Sharding, sharding);
		String excuSql = SplitTableFactory.createQuerySQL(sql, objTableVars);
		Map paramter = new HashMap();
		paramter.put(IBOInvoiceBusiFeatureValue.S_Sharding, sharding);
		return BOInvoiceBusiFeatureEngine.getBeansFromSql(sql, paramter);
	}

	@Override
	public BOMonthlyAutoCustomizeBean getMonthlyAutoCustomize(String billId, long custId, long userId, long acctId,
			String sharding) throws Exception {
		String table = BOMonthlyAutoCustomizeBean.getObjectTypeStatic().getMapingEnty();
		table = StringUtils.replace(table, "{", "");
		table = StringUtils.replace(table, "}", "");

		StringBuffer boSql = new StringBuffer();
		boSql.append(" select * from ").append("{").append(table).append("}");
		boSql.append(" where 1=1");
		Map paramMap = new HashMap();
		if (!org.apache.commons.lang.StringUtils.isBlank(billId)) {
			boSql.append(" and ").append(BOMonthlyAutoCustomizeBean.S_BillId).append(" = :")
					.append(BOMonthlyAutoCustomizeBean.S_BillId);
			paramMap.put(BOMonthlyAutoCustomizeBean.S_BillId, billId);
		}

		if (custId > 0) {
			boSql.append(" and ").append(BOMonthlyAutoCustomizeBean.S_CustId).append(" = :")
					.append(BOMonthlyAutoCustomizeBean.S_CustId);
			paramMap.put(BOMonthlyAutoCustomizeBean.S_CustId, custId);
		}

		if (userId > 0) {
			boSql.append(" and ").append(BOMonthlyAutoCustomizeBean.S_UserId).append(" = :")
					.append(BOMonthlyAutoCustomizeBean.S_UserId);
			paramMap.put(BOMonthlyAutoCustomizeBean.S_UserId, userId);
		}

		if (acctId > 0) {
			boSql.append(" and ").append(BOMonthlyAutoCustomizeBean.S_AcctId).append(" = :")
					.append(BOMonthlyAutoCustomizeBean.S_AcctId);
			paramMap.put(BOMonthlyAutoCustomizeBean.S_AcctId, acctId);
		}
		boSql.append(" and ").append(BOMonthlyAutoCustomizeBean.S_State).append(" = :")
				.append(BOMonthlyAutoCustomizeBean.S_State);
		paramMap.put(BOMonthlyAutoCustomizeBean.S_State, EInvoiceConst.CommonState.U);

		TableVars objTableVars = new TableVars();
		objTableVars.add(table, "SHARDING", sharding);
		String excuSql = SplitTableFactory.createQuerySQL(boSql.toString(), objTableVars);
		BOMonthlyAutoCustomizeBean[] values = BOMonthlyAutoCustomizeEngine.getBeansFromSql(excuSql, paramMap);
		return values != null && values.length > 0 ? values[0] : null;
	}

	@Override
	public void saveInvoicePusherTask(IBOInvoicePushTaskValue task) throws Exception {
		if (task != null) {
			if (task.getPushTaskId() == 0) {
				task.setPushTaskId(BOInvoicePushTaskEngine.getNewId().longValue());
			}
			task.setState(Constant.CommonState.VALIDATION);
			BOInvoicePushTaskEngine.save(task);
		}
	}

	@Override
	public void saveInvoicePusherTaskHis(IBOInvoicePushTaskHisValue task) throws Exception {
		BOInvoicePushTaskHisEngine.save(task);

	}

	@Override
	public void saveInvoicePresInst(IBOInvoicePresInstValue inst) throws Exception {
		if (inst.getInvoiceInstanceId() == 0) {
			throw new Exception("没有发票实例ID，发票文件信息不能存档");
		}
		BOInvoicePresInstEngine.save(inst);
	}

	@Override
	public long saveInvoiceDs(IBOInvoiceDsValue ds) throws Exception {
		if (ds.getInvoiceDsId() == 0) {
			ds.setInvoiceDsId(BOInvoiceDsEngine.getNewId().longValue());
		}
		BOInvoiceDsEngine.save(ds);
		return ds.getInvoiceDsId();
	}

	@Override
	public void saveInvoiceDsItems(IBOInvoiceDsDtlValue[] dtls) throws Exception {
		if (!ArrayUtils.isEmpty(dtls)) {
			for (IBOInvoiceDsDtlValue dtl : dtls) {
				dtl.setInvoiceDsDetailId(BOInvoiceDsDtlEngine.getNewId().longValue());
			}
			BOInvoiceDsDtlEngine.saveBatch(dtls);
		}

	}

	@Override
	public void saveInvoiceBusiFeature(IBOInvoiceBusiFeatureValue feature) throws Exception {
		if (feature.getInvoiceDsId() == 0) {
			throw new Exception("没有发票数据源ID，业务信息不能存档");
		}
		BOInvoiceBusiFeatureEngine.save(feature);
	}

	@Override
	public void saveInvoiceDsDispatch(IBOInvoiceDsDispatchValue dispatch) throws Exception {
		if (dispatch != null) {
			if (dispatch.getDispatchId() == 0) {
				dispatch.setDispatchId(BOInvoiceDsDispatchEngine.getNewId().longValue());
			}
			dispatch.setCreateTime(TimeUtil.getSysTime());
			if (StringUtils.isEmpty(dispatch.getState())) {
				logger.warn("没有设置调度状态，系统默认设置为初始状态C");
				dispatch.setState(EInvoiceConst.DispatchState.CREATE);
			}
			BOInvoiceDsDispatchEngine.save(dispatch);
		}
	}

	@Override
	public long saveInvoiceInst(IBOInvoiceInstValue inst) throws Exception {
		if (inst.getInvoiceInstanceId() == 0) {
			inst.setInvoiceInstanceId(BOInvoiceDsEngine.getNewId().longValue());
		}
		BOInvoiceInstEngine.save(inst);
		return inst.getInvoiceInstanceId();
	}

	@Override
	public void saveInvoiceInstItems(IBOInvoiceInstItemValue[] dtls) throws Exception {
		if (!ArrayUtils.isEmpty(dtls)) {
			for (IBOInvoiceInstItemValue dtl : dtls) {
				dtl.setInvoiceInstanceItemId(BOInvoiceInstItemEngine.getNewId().longValue());
			}
			BOInvoiceInstItemEngine.saveBatch(dtls);
		}
	}

	public void saveInvoiceMsgLog(IBOInvoiceMsgLogValue log) throws Exception {
		if (log != null) {
			long msgId = log.getMessageId();
			if (msgId == 0) {
				log.setMessageId(BOInvoiceMsgLogEngine.getNewId().longValue());
			}
			BOInvoiceMsgLogEngine.save(log);
		}
	}

	public void delEInvoiceDsDispatch(BOInvoiceDsDispatchBean dispatch) throws Exception {
		dispatch.delete();
		BOInvoiceDsDispatchEngine.save(dispatch);
	}

	@Override
	public void saveMonthlyAutoCustomize(BOMonthlyAutoCustomizeBean monthly) throws Exception {
		if (monthly != null) {
			BOMonthlyAutoCustomizeEngine.save(monthly);
		}
	}

	@Override
	public void saveEInvoiceDsPushReqs(BOInvoiceDsPushReqBean[] reqs) throws Exception {
		if (!ArrayUtils.isEmpty(reqs)) {
			for (BOInvoiceDsPushReqBean req : reqs) {
				if (req.getPushReqId() == 0) {
					req.setPushReqId(BOInvoiceDsPushReqEngine.getNewId().longValue());
				}
			}
			BOInvoiceDsPushReqEngine.save(reqs);
		}
	}

}
