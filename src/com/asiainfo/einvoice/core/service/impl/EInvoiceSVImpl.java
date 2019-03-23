package com.asiainfo.einvoice.core.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.common.util.TimeUtil;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.ArrayUtils;
import com.asiainfo.einvoice.EInvoiceConst;
import com.asiainfo.einvoice.commons.template.EInvoiceTemplateProvider;
import com.asiainfo.einvoice.commons.template.impl.SqlTemplateEngine;
import com.asiainfo.einvoice.commons.template.impl.XmlTemplateEngine;
import com.asiainfo.einvoice.core.EInvoiceFactory;
import com.asiainfo.einvoice.core.def.BusiMsg;
import com.asiainfo.einvoice.core.def.CrmRequestMsg;
import com.asiainfo.einvoice.core.def.InvoiceDsBean;
import com.asiainfo.einvoice.core.def.InvoiceFileInfo;
import com.asiainfo.einvoice.core.def.InvoiceItemMsg;
import com.asiainfo.einvoice.core.def.InvoiceMsg;
import com.asiainfo.einvoice.core.def.PushInfo;
import com.asiainfo.einvoice.core.def.SkResponseMsg;
import com.asiainfo.einvoice.core.def.bo.bean.BOBusiFeatureRelDefBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceBusiFeatureBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDispatchBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsPushReqBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsPushReqEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstItemBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceMsgLogBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoicePresInstBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoicePushTaskBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoicePushTaskHisBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOMonthlyAutoCustomizeBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOMonthlyAutoCustomizeEngine;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOBusiFeatureRelDefValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceBusiFeatureValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsDispatchValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsDtlValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstItemValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePushTaskHisValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePushTaskValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOMonthlyAutoCustomizeValue;
import com.asiainfo.einvoice.core.service.interfaces.IEInvoiceSV;
import com.asiainfo.einvoice.customized.message.parser.interfaces.IEInvoiceMessageParser;
import com.asiainfo.einvoice.customized.message.pusher.interfaces.IEInvoiceMessagePusher;
import com.asiainfo.einvoice.inter.sk.interfaces.ISkClientSV;
import com.asiainfo.einvoice.util.DataModelUtil;
import com.asiainfo.einvoice.util.EInvoiceUtil;
import com.asiainfo.einvoice.util.ExecuteEvent;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

public class EInvoiceSVImpl implements IEInvoiceSV {
	private Log logger = LogFactory.getLog(EInvoiceSVImpl.class);

	public long issuingEInvoice(CrmRequestMsg crmRequestMsg, String regionId, String billCycle) throws Exception {
		// 1、校验数据完整性
		checkInvoiceDataValid(crmRequestMsg);
		// 检查是否已经开过票（包括纸质发票）
		if (hasIssuingRecord(crmRequestMsg)) {
			throw new Exception("已经开具过发票，不能重复开具");
		}
		String sharding = regionId + "_" + billCycle;

		// 2、生成电子发票数据源数据
		InvoiceDsBean invoiceDsAll = generatorEInvoiceDs(crmRequestMsg, sharding, false);

		BOInvoiceDsBean dsBean = invoiceDsAll.getInvoiceDsValue();
		BOInvoiceDsDtlBean[] dsItemBeans = invoiceDsAll.getInvoiceDsDtlValues();

		// 3、请求税控平台开具电子发票
		SkResponseMsg skReturnMsg = requestIssuingEInvoice(dsBean, dsItemBeans);

		// 5、生成电子发票开具记录
		BOInvoiceInstBean inst = generatorEInvoiceRecord(null, dsBean, skReturnMsg, sharding);

		dsBean.setDsState(EInvoiceConst.Dstate.ISSUING);
		EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDs(dsBean);

		// 6、税控接口返回成功即表明发票开具成功，文件处理发生异常不影响整个开具服务
		boolean isPdfSuccess = persistentEInvoiceInst(inst, skReturnMsg);

		// pdf文件持久化成功,如果需要推送，则生成推送工单；否在在文件持久化成功后生成
		if (isPdfSuccess) {
			createInvoicePushTask(invoiceDsAll.getBoInvoiceDsPushReqBeans(), dsBean.getSharding(),
					inst.getInvoiceDsId(), inst.getInvoiceInstanceId());
		}
		return inst.getInvoiceInstanceId();
	}

	public long issuingEInvoiceAsync(CrmRequestMsg crmRequestMsg, String regionId, String billCycle) throws Exception {
		// 1、校验数据完整性
		checkInvoiceDataValid(crmRequestMsg);
		// 检查是否已经开过票（包括纸质发票）
		if (hasIssuingRecord(crmRequestMsg)) {
			throw new Exception("已经开具过发票，不能重复开具");
		}
		String sharding = CenterFactory.getCenterInfo().getRegion();

		// 2、生成电子发票数据源数据
		InvoiceDsBean invoiceDsAll = generatorEInvoiceDs(crmRequestMsg, sharding, false);

		BOInvoiceDsBean dsBean = invoiceDsAll.getInvoiceDsValue();
		BOInvoiceDsDtlBean[] dsItemBeans = invoiceDsAll.getInvoiceDsDtlValues();

		// 3、请求税控平台开具电子发票
		SkResponseMsg skReturnMsg = requestIssuingEInvoice(dsBean, dsItemBeans);
		String code = skReturnMsg.getReturnCode();
		//
		if ("0000".equals(code) || "0".equals(code)) {
			// TODO:通过异步的请求工单
		} else {
			throw new Exception(skReturnMsg.getReturnMsg());
		}
		return dsBean.getInvoiceDsId();
	}

	public void issuingEInvoiceBatch(CrmRequestMsg crmRequestMsg, String regionId, String billCycle) throws Exception {
		// 月结自动开具时使用这个接口，通过dispatch触发开具操作
		// 1、校验数据完整性
		checkInvoiceDataValid(crmRequestMsg);

		// 2、检查是否已经开过票（包括纸质发票）
		if (hasIssuingRecord(crmRequestMsg)) {
			throw new Exception("已经开具过发票，不能重复开具");
		}
		String sharding = regionId + "_" + billCycle;
		// 3、生成电子发票数据源数据
		generatorEInvoiceDs(crmRequestMsg, sharding, true);
	}

	public void issuingEInvoiceBatchDisaptch(long invoiceDsId, String regionId, String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;

		BOInvoiceDsBean ds = queryEInvoiceDsByDsId(invoiceDsId, regionId, billCycle);
		if (ds == null || ds.isNew()) {
			throw new RuntimeException("根据数据源id：" + invoiceDsId + "没有找到存在的数据！");
		}
		BOInvoiceDsDtlBean[] dtls = EInvoiceFactory.getIEInvoiceSV().queryEInvoiceDsDtlByDsId(invoiceDsId, regionId,
				billCycle);
		BOInvoiceDsPushReqBean[] boInvoiceDsPushReqBeans = EInvoiceFactory.getIEInvoiceDAO()
				.queryEInvoiceDsPushReqs(invoiceDsId, sharding);

		// 检查是否已经开过票（包括纸质发票）
		boolean is = EInvoiceFactory.getIssuingChecker().beforCheck(ds, dtls);
		if (is) {
			throw new Exception("已经开具过发票，不能重复开具");
		}
		// 3、请求税控平台开具电子发票
		SkResponseMsg skReturnMsg = requestIssuingEInvoice(ds, dtls);

		// 5、生成电子发票开具记录
		BOInvoiceInstBean inst = generatorEInvoiceRecord(null, ds, skReturnMsg, sharding);
		ds.setDsState(EInvoiceConst.Dstate.ISSUING);
		EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDs(ds);
		// 6、税控接口返回成功即表明发票开具成功，文件处理发生异常不影响整个开具服务
		boolean isPdfSuccess = persistentEInvoiceInst(inst, skReturnMsg);

		// pdf文件持久化成功,如果需要推送，则生成推送工单；否在在文件持久化成功后生成
		if (isPdfSuccess) {
			createInvoicePushTask(boInvoiceDsPushReqBeans, sharding, inst.getInvoiceDsId(),
					inst.getInvoiceInstanceId());
		}
	}

	public long issuingEInvoiceRed(CrmRequestMsg crmRequestMsg, String regionId, String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;
		// 1、电子发票开具记录查询
		InvoiceMsg msg = crmRequestMsg.getInvoiceMsg();
		long insId = msg.getInvoiceInsId();
		// 2、查询发票实例
		BOInvoiceInstBean inst = EInvoiceFactory.getIEInvoiceDAO().getInvoiceInsById(insId, sharding);
		if (inst == null) {
			throw new RuntimeException("根据电子发票实例id：" + insId + "没有找到发票实例！");
		}
		// 3、验证是否已经有过冲红记录
		if (hasRedRecord(inst.getInvoiceDsId(), sharding)) {
			throw new Exception("已经冲红过该发票，不能再次冲红！");
		}
		// 4、请求税控平台冲红电子发票
		SkResponseMsg skReturnMsg = requestRedEInvoice(inst);
		// 5、生成电子发票开具记录
		BOInvoiceDsBean ds = EInvoiceFactory.getIEInvoiceDAO().getInvoiceDsById(inst.getInvoiceDsId(), sharding);
		BOInvoiceInstBean redInst = generatorEInvoiceRecord(inst, ds, skReturnMsg, sharding);

		// 6:更新原发票实例
		inst.setIssuingFlag(EInvoiceConst.IssuingFlag.HAS_RED);
		EInvoiceFactory.getIEInvoiceDAO().saveInvoiceInst(inst);

		ds.setDsState(EInvoiceConst.Dstate.ISSUING_RED);
		EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDs(ds);

		// 7、持久化PDF文件
		// 税控接口返回成功即表明发票开具成功，文件处理发生异常不影响整个开具服务
		boolean isPdfSuccess = persistentEInvoiceInst(redInst, skReturnMsg);
		if (isPdfSuccess) {
			// 冲红发票不发送推送工单
			// createInvoicePushTask(crmRequestMsg.getPushInfos(),
			// ds.getSharding(), inst.getInvoiceInstanceId());
		}
		return redInst.getInvoiceInstanceId();
	}

	private boolean hasIssuingRecord(CrmRequestMsg msg) throws Exception {
		// 数据源
		BOInvoiceDsBean ds = DataModelUtil.convertBean2Dc(msg.getInvoiceMsg(), BOInvoiceDsBean.class);
		InvoiceItemMsg[] items = msg.getInvoiceItemMsgs();

		// 数据源详情
		BOInvoiceDsDtlBean[] dtls = null;
		if (!ArrayUtils.isEmpty(items)) {
			dtls = new BOInvoiceDsDtlBean[items.length];
			for (int i = 0; i < items.length; i++) {
				BOInvoiceDsDtlBean dtl = DataModelUtil.convertBean2Dc(items[i], BOInvoiceDsDtlBean.class);
				dtls[i] = (dtl);
			}
		}
		return EInvoiceFactory.getIssuingChecker().beforCheck(ds, dtls);
	}

	/**
	 * 是否已经开具冲红发票
	 *
	 * @param invoiceDsId
	 * @return
	 * @throws Exception
	 */
	private boolean hasRedRecord(long invoiceDsId, String sharding) throws Exception {
		IBOInvoiceInstValue[] ds = EInvoiceFactory.getIEInvoiceDAO().getInvoiceInsByDefId(invoiceDsId, sharding);
		if (!ArrayUtils.isEmpty(ds)) {
			for (IBOInvoiceInstValue inst : ds) {
				if (EInvoiceConst.IssuingFlag.RED.equals(inst.getIssuingFlag())) {
					return true;
				}
			}
		}
		return false;
	}

	public void createInvoicePushTask(BOInvoiceDsPushReqBean[] dsPushReqBeans, String sharding, long invoiceDsId,
			long invoiceInsId) throws Exception {
		// 如果不推送，则不生成工单
		if (!ArrayUtils.isEmpty(dsPushReqBeans)) {
			for (BOInvoiceDsPushReqBean info : dsPushReqBeans) {
				if (EInvoiceConst.PushWay.NO.equals(info.getPushWay())) {
					return;
				}
				// 如果全部推送，需要生成多张工单
				createInvoicePushTask(sharding, invoiceDsId, invoiceInsId, info.getPushWay(), info.getPushTarget());
			}
		}
	}

	/*
	 * 保存推送工单
	 */
	private void createInvoicePushTask(String sharding, long invoiceDsId, long invoiceInsId, String sendType,
			String sendTarget) throws Exception {
		IBOInvoicePushTaskValue task = new BOInvoicePushTaskBean();
		task.setPushWay(sendType);
		task.setInvoiceDsId(invoiceDsId);
		task.setInvoiceInstanceId(invoiceInsId);
		task.setPushTarget(sendTarget);
		task.setSharding(sharding);
		EInvoiceFactory.getIEInvoiceDAO().saveInvoicePusherTask(task);
	}

	@Override
	public SkResponseMsg callSkQuery(BOInvoiceInstBean inst) throws Exception {
		// 获取税控查询报文模板
		XmlTemplateEngine engine = EInvoiceTemplateProvider.getSkQueryReqXmlEngine();
		// 设置参数
		engine.setParams(inst);
		// 渲染报文
		String queryMsg = engine.render();
		// 获取税控客户端
		ISkClientSV client = EInvoiceFactory.getISkClientSV();
		// 调用查询发票接口
		String rtn = client.queryInvoice(queryMsg);
		// 获取消息解析器
		IEInvoiceMessageParser parser = EInvoiceFactory.getIEInvoiceMessageParser();
		return parser.parseSkReturn(rtn);
	}

	public void callSkQueryPersistentPdf(long eInvoiceInstId, String regionId, String billCycle) throws Exception {
		BOInvoiceInstBean instBean = (BOInvoiceInstBean) queryEInvoiceInst(eInvoiceInstId, regionId, billCycle);
		persistentEInvoiceInst(instBean, callSkQuery(instBean));
	}

	@Override
	public void pushingEinvoice(long pushTaskId, String regionId, String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;
		// 获取推送工单
		IBOInvoicePushTaskValue task = EInvoiceFactory.getIEInvoiceDAO().getInvoicePusherTaskByTaskId(pushTaskId,
				sharding);
		// 如果推送工单不为空
		if (task != null) {
			// 推送方式
			String pushWay = task.getPushWay();
			// 获取推送接口
			IEInvoiceMessagePusher pusher = EInvoiceFactory.getIEInvoiceMessagePusher(pushWay);
			// 推送
			pusher.push(task);

			move2his(task);

		}
	}

	private void move2his(IBOInvoicePushTaskValue task) throws Exception {
		task.delete();
		EInvoiceFactory.getIEInvoiceDAO().saveInvoicePusherTask(task);

		IBOInvoicePushTaskHisValue his = new BOInvoicePushTaskHisBean();
		Map map = task.getProperties();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object val = map.get(key);
			his.set(key, val);
		}
		EInvoiceFactory.getIEInvoiceDAO().saveInvoicePusherTaskHis(his);
	}

	@Override
	public void pushingEinvoice(long invoiceInstId, String pushWay, String pushTarget, String regionId,
			String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;
		// 获取推送工单
		IBOInvoicePushTaskValue task = new BOInvoicePushTaskBean();
		task.setInvoiceInstanceId(invoiceInstId);
		// 获取推送接口
		IEInvoiceMessagePusher pusher = EInvoiceFactory.getIEInvoiceMessagePusher(pushWay);
		// 推送
		pusher.push(task);
	}

	@Override
	public void fjNofity(String billId, long custId, long userId, long acctId, String regionId) throws Exception {
		BOMonthlyAutoCustomizeBean monthly = EInvoiceFactory.getIEInvoiceDAO().getMonthlyAutoCustomize(billId, custId,
				userId, acctId, regionId);
		if (monthly != null) {
			// 首先查看是否有之前的为开发票
			String mark = monthly.getPreIssuingMark();
			String[] cycle = null;
			if (StringUtils.isNotBlank(mark)) {
				// 通过mark计算欠费的月份，数组
				cycle = calcArrearTime(mark);
				//
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
				cycle = new String[] { format.format(new Date()) };
			}
			if (!ArrayUtils.isEmpty(cycle)) {
				for (String c : cycle) {
					// 如果结清费用，则恢复月结费用发送
					if (isArrears(monthly, c)) {
						// 调用账管接口，查询用户的发票信息
						CrmRequestMsg msg = EInvoiceFactory.getIAmsClientSV().queryInvoiceData(monthly.getCustId(),
								monthly.getUserId(), monthly.getAcctId(), monthly.getBillId(), regionId, c);
						EInvoiceFactory.getIEInvoiceSV().issuingEInvoiceBatch(msg, regionId, c);
					} else {
						// 如果有未结清账单，需要将未开票时间记录下来，等待下次开票时判断
						if (com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils
								.isBlank(monthly.getPreIssuingMark())) {
							SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
							monthly.setPreIssuingMark(format.format(new Date()));
						}
						// 记录未开票年月
						EInvoiceFactory.getIEInvoiceDAO().saveMonthlyAutoCustomize(monthly);
					}
				}
			}
		}
	}

	// 开票之前检查用户是否欠费。
	private boolean isArrears(BOMonthlyAutoCustomizeBean monthly, String cycle) throws Exception {
		return EInvoiceFactory.getIAmsClientSV().isUserArrears(monthly.getCustId(), monthly.getUserId(),
				monthly.getAcctId(), monthly.getBillId(), monthly.getSharding(), cycle);
	}

	private String[] calcArrearTime(String mark) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date date = format.parse(mark);
		// this month
		Calendar cal = Calendar.getInstance();
		// 换算相差的月份数
		int month = cal.get(Calendar.YEAR) * 12 + cal.get(Calendar.MONTH) - (date.getYear() * 12 + date.getMonth());
		//
		String[] cycle = new String[month];
		for (int i = 0; i < month; i++) {
			cal.set(Calendar.MONTH, -1);
			cycle[i] = cal.get(Calendar.YEAR) + "" + cal.get(Calendar.MONTH);
		}
		return cycle;
	}

	private boolean persistentEInvoiceInst(BOInvoiceInstBean inst, SkResponseMsg msg) throws Exception {
		try {
			// 读取文件字符到输入流
			ByteArrayInputStream inputStream = new ByteInputStream();
			inputStream.read(msg.getPdfFile().getBytes());
			// 上传文件
			InvoiceFileInfo file = EInvoiceFactory.getIEInvoiceFileSV().upload(inst.getInvoiceInstanceId(),
					inputStream);
			// 入库
			// 将发票实例混入文件实例中
			BOInvoicePresInstBean pres = DataModelUtil.mixDc(BOInvoicePresInstBean.class, inst);
			// 将文件信息混入文件实例中
			DataModelUtil.insertBean2Dc(file, pres);
			// 保存文件信息
			EInvoiceFactory.getIEInvoiceDAO().saveInvoicePresInst(pres);
			return true;
		} catch (Exception e) {
			logger.error("电子发票pdf文件持久化失败(不影响发票开具成功结果)," + e.getMessage(), e);
			// 设置标志or能够体检pdf文件持久失败
			// 放入调度中
			try {
				IBOInvoiceDsDispatchValue dispatch = new BOInvoiceDsDispatchBean();
				dispatch.setDispatchCount(0);
				dispatch.setInvoiceDsId(inst.getInvoiceDsId());
				dispatch.setInvoiceInstanceId(inst.getInvoiceInstanceId());
				dispatch.setSharding(inst.getSharding().split("_")[0]);
				dispatch.setTargetSharding(inst.getSharding());
				dispatch.setState(EInvoiceConst.DispatchState.CREATE);
				dispatch.setDispatchKind(EInvoiceConst.DispatchKind.ASYNC_DL_PDF);
				dispatch.setTargetSharding(inst.getSharding());
				dispatch.setSharding(inst.getSharding().split("_")[0]);
				EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDsDispatch(dispatch);
			} catch (Exception e1) {
				// 调度表记录失败不影响整个流程，将PDF上传放在第一次查询的时候
				logger.error("记录文件上传调度失败(不影响发票开具成功结果)," + e.getMessage(), e);
			}
			return false;
		}
	}

	public IBOMonthlyAutoCustomizeValue queryMonthlyAutoCustomized(String billid, long custid, long userid, long acctid,
			String sharding) throws Exception {
		return EInvoiceFactory.getIEInvoiceDAO().getMonthlyAutoCustomize(billid, custid, userid, acctid, sharding);
	}

	@Override
	public void monthlyAutoCustomized(Map map, String region) throws Exception {
		BOMonthlyAutoCustomizeBean customize = new BOMonthlyAutoCustomizeBean();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object val = map.get(key);
			customize.set(key, val);
		}
		customize.setSharding(region);
		if (customize.getCustomizeId() <= 0) {
			customize.setCustomizeId(BOMonthlyAutoCustomizeEngine.getNewId().longValue());
			customize.setState(EInvoiceConst.CommonState.U);
		}
		BOMonthlyAutoCustomizeEngine.save(customize);
	}

	@Override
	public InputStream downloadEInvoiceInst(long invoiceInstId, String regionId, String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;
		IBOInvoicePresInstValue inst = EInvoiceFactory.getIEInvoiceDAO().getInvoicePresInstByInvInsId(invoiceInstId,
				sharding);
		// 通过文件记录下载文件
		if (inst != null) {
			return EInvoiceFactory.getIEInvoiceFileSV().download(inst);
		} else {
			throw new Exception("未找到文件记录！");
		}

	}

	@Override
	public IBOInvoiceDsValue[] queryEInvoiceDs(String busiType, Map<String, ?> conditionVal, Map<String, ?> conditionOp,
			String regionId, String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;
		IBOInvoiceDsValue[] rtn = null;
		// 通过业务场景找到对应的数据源ID
		IBOBusiFeatureRelDefValue[] defs = EInvoiceFactory.getIEInvoiceDAO().getBusiFeatureRelDefByBusiType(busiType);
		if (!ArrayUtils.isEmpty(defs)) {
			// 映射字段
			Map<String, String> fields = new HashMap();
			for (IBOBusiFeatureRelDefValue def : defs) {
				String field = def.getFeatureField();
				fields.put(def.getFeatureCode().toUpperCase(), field);
			}
			BOInvoiceBusiFeatureBean def = new BOInvoiceBusiFeatureBean();
			// 获取SQL模板引擎
			SqlTemplateEngine engine = EInvoiceTemplateProvider.getSqlTemplateEngine();
			// 设置表名
			engine.setTableName(def.fetchTableName());
			// 拼写参数
			if (conditionVal != null && conditionVal.size() > 0) {
				Iterator itr = conditionVal.entrySet().iterator();
				while (itr.hasNext()) {
					Map.Entry entry = (Map.Entry) itr.next();
					String param = (String) entry.getKey();
					if (StringUtils.isNotBlank(param) && fields.containsKey(param.toUpperCase())) {
						engine.addParams(fields.get(param.toUpperCase()), convertOp(conditionOp.get(param).toString()),
								(String) entry.getValue());
					}
				}
			}
			// 通过SQL查询
			IBOInvoiceBusiFeatureValue[] rels = EInvoiceFactory.getIEInvoiceDAO()
					.getInvoiceBusiFeatureBySql(engine.render(), sharding);
			if (!ArrayUtils.isEmpty(rels)) {
				List<IBOInvoiceDsValue> list = new ArrayList();
				for (IBOInvoiceBusiFeatureValue rel : rels) {
					list.add(EInvoiceFactory.getIEInvoiceDAO().getInvoiceDsById(rel.getInvoiceDsId(), sharding));
				}
				rtn = list.toArray(new IBOInvoiceDsValue[0]);
			}
		}
		return rtn;
	}

	private String convertOp(String param) {
		return param;
	}

	@Override
	public IBOInvoiceInstValue[] queryEInvoiceInsts(long eInvoiceDsId, String regionId, String billCycle)
			throws Exception {
		String sharding = regionId + "_" + billCycle;
		return EInvoiceFactory.getIEInvoiceDAO().getInvoiceInsByDefId(eInvoiceDsId, sharding);
	}

	@Override
	public IBOInvoiceInstValue queryEInvoiceInst(long eInvoiceInstId, String regionId, String billCycle)
			throws Exception {
		String sharding = regionId + "_" + billCycle;
		return EInvoiceFactory.getIEInvoiceDAO().getInvoiceInsById(eInvoiceInstId, sharding);
	}

	public BOInvoiceDsBean queryEInvoiceDs(String soOrderId, String soSeriaId, String regionId, String billCycle)
			throws Exception {
		String sharding = regionId + "_" + billCycle;
		return EInvoiceFactory.getIEInvoiceDAO().queryEInvoiceDs(soOrderId, soSeriaId, sharding);
	}

	@Override
	public BOInvoiceDsBean queryEInvoiceDsByDsId(long dsId, String regionId, String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;
		return EInvoiceFactory.getIEInvoiceDAO().getInvoiceDsById(dsId, sharding);
	}

	/**
	 * 生成电子发票数据源数据
	 *
	 * @param crmRequestMsg
	 * @param isDispatch
	 *            是否生成数据源调度实例
	 * @return
	 * @throws Exception
	 */
	private InvoiceDsBean generatorEInvoiceDs(CrmRequestMsg crmRequestMsg, String sharding, boolean isDispatch)
			throws Exception {
		InvoiceDsBean bean = new InvoiceDsBean();
		// 1、数据源实例处理
		InvoiceMsg msg = crmRequestMsg.getInvoiceMsg();
		long invoiceDsId = -1;
		BOInvoiceDsBean ds = null;
		if (msg != null) {
			ds = DataModelUtil.convertBean2Dc(msg, BOInvoiceDsBean.class);
			ds.setDsState(EInvoiceConst.Dstate.NORMAL);
			ds.setCreateTime(new Timestamp(new Date().getTime()));
			ds.setSharding(sharding);
			invoiceDsId = EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDs(ds);
		}
		bean.setInvoiceDsValue(ds);
		// 2、数据源实例属性处理
		Map invoiceAttrMap = crmRequestMsg.getInvoiceMsg().getAttributeMap();
		if (invoiceAttrMap != null) {
			// TODO:
		}
		// 3、数据源实例业务特征处理
		IBOInvoiceBusiFeatureValue feature = null;
		BusiMsg busi = crmRequestMsg.getBusiMsg();
		if (busi != null) {
			feature = DataModelUtil.convertBean2Dc(busi, BOInvoiceBusiFeatureBean.class);
			// 注入数据源
			feature.setInvoiceDsId(invoiceDsId);
			feature.setSharding(sharding);
			// 保存数据
			EInvoiceFactory.getIEInvoiceDAO().saveInvoiceBusiFeature(feature);
		}

		// 4、数据源实例条目明细处理
		InvoiceItemMsg[] items = crmRequestMsg.getInvoiceItemMsgs();
		BOInvoiceDsDtlBean[] dtls = null;
		if (!ArrayUtils.isEmpty(items)) {
			dtls = new BOInvoiceDsDtlBean[items.length];
			for (int i = 0; i < items.length; i++) {
				BOInvoiceDsDtlBean dtl = DataModelUtil.convertBean2Dc(items[i], BOInvoiceDsDtlBean.class);
				dtl.setInvoiceDsId(invoiceDsId);
				dtl.setSharding(sharding);
				dtls[i] = (dtl);
			}
			EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDsItems(dtls);
		}
		bean.setInvoiceDsDtlValues(dtls);

		// 5、数据源推送请求处理
		PushInfo[] pushInfos = crmRequestMsg.getPushInfos();
		if (pushInfos != null && pushInfos.length > 0) {
			BOInvoiceDsPushReqBean[] pushReqs = new BOInvoiceDsPushReqBean[pushInfos.length];
			for (int i = 0; i < pushInfos.length; i++) {
				pushReqs[i] = new BOInvoiceDsPushReqBean();
				pushReqs[i].setPushReqId(BOInvoiceDsPushReqEngine.getNewId().longValue());
				pushReqs[i].setInvoiceDsId(invoiceDsId);
				pushReqs[i].setPushWay(pushInfos[i].getPushWay());
				pushReqs[i].setPushTarget(pushInfos[i].getPushTarget());
				pushReqs[i].setSharding(sharding);
			}
			EInvoiceFactory.getIEInvoiceDAO().saveEInvoiceDsPushReqs(pushReqs);
			bean.setBoInvoiceDsPushReqBeans(pushReqs);
		}

		// 6、数据源调度实例处理
		if (isDispatch) {
			// 进入调度表
			IBOInvoiceDsDispatchValue dispatch = new BOInvoiceDsDispatchBean();
			dispatch.setInvoiceDsId(invoiceDsId);
			dispatch.setDispatchCount(0);
			dispatch.setCreateTime(TimeUtil.getPrimaryDataSourceSysDate());
			dispatch.setState(EInvoiceConst.DispatchState.CREATE);
			dispatch.setDispatchKind(EInvoiceConst.DispatchKind.ASYNC_ISSUING);
			dispatch.setTargetSharding(sharding);
			dispatch.setSharding(sharding.split("_")[0]);
			EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDsDispatch(dispatch);
		}
		//

		return bean;
	}

	/**
	 * 生成电子发票记录
	 *
	 * @return
	 * @throws Exception
	 */
	private BOInvoiceInstBean generatorEInvoiceRecord(BOInvoiceInstBean oldInst, BOInvoiceDsBean dsBean,
			SkResponseMsg returnMsg, String sharding) throws Exception {
		// 混入税控返回消息
		BOInvoiceInstBean inst = DataModelUtil.mixBean2Dc(BOInvoiceInstBean.class, returnMsg);
		// 混入DS数据源
		DataModelUtil.mixDc(inst, dsBean);

		inst.setIssuingType(EInvoiceConst.IssuingType.E_INVOICE);
		if (oldInst != null) {
			// 填写被冲红的发票数据
			inst.setOldInvoiceInstanceId(oldInst.getInvoiceInstanceId());
			inst.setOldInvoiceNumber(oldInst.getInvoiceNumber());
			inst.setOldInvoiceCode(oldInst.getInvoiceCode());
			inst.setIssuingFlag(EInvoiceConst.IssuingFlag.RED);
		} else {
			inst.setIssuingFlag(EInvoiceConst.IssuingFlag.NORMAL);
		}
		inst.setInvoiceAmount(dsBean.getTotalAmount());
		inst.setInvoicePrice(dsBean.getTotalPrice());
		inst.setInvoiceTax(dsBean.getTotalTax());
		inst.setInvoiceType(dsBean.getInvoiceType());
		Timestamp now = new Timestamp(new Date().getTime());
		inst.setIssuingTime(now);
		inst.setCreateTime(now);
		inst.setSharding(sharding);
		// 保存发票数据
		long instId = EInvoiceFactory.getIEInvoiceDAO().saveInvoiceInst(inst);

		// 将实例ID回填到inst
		inst.setInvoiceInstanceId(instId);
		// 处理详情
		IBOInvoiceDsDtlValue[] dtls = EInvoiceFactory.getIEInvoiceDAO().getInvoiceDsDtlByDsId(dsBean.getInvoiceDsId(),
				sharding);
		if (!ArrayUtils.isEmpty(dtls)) {
			List<IBOInvoiceInstItemValue> l = new ArrayList();
			for (IBOInvoiceDsDtlValue dtl : dtls) {
				long detailId = dtl.getInvoiceDsDetailId();
				IBOInvoiceInstItemValue item = new BOInvoiceInstItemBean();
				item.setSharding(dsBean.getSharding());
				item.setInvoiceDsDetailId(detailId);
				item.setInvoiceInstanceId(instId);
				l.add(item);
			}
			EInvoiceFactory.getIEInvoiceDAO().saveInvoiceInstItems(l.toArray(new IBOInvoiceInstItemValue[0]));
		}
		return inst;
	}

	/**
	 * 请求税控平台开具电子发票
	 *
	 * @throws Exception
	 */
	private SkResponseMsg requestIssuingEInvoice(BOInvoiceDsBean dsBean, BOInvoiceDsDtlBean[] dsItemBeans)
			throws Exception {
		// 组装消息
		String requestMessage = EInvoiceFactory.getIEInvoiceSkMessageBuilder().buildSkIssuingMsg(dsBean, dsItemBeans);
		// 调用税控系统电子发票开具接口
		String responseMessage = EInvoiceFactory.getISkClientSV().issuingInvoice(requestMessage);
		// 处理回复的消息
		try {
			SkResponseMsg skReturnMsg = EInvoiceFactory.getIEInvoiceMessageParser().parseSkReturn(responseMessage);
			return skReturnMsg;
		} catch (Exception e) {
			throw e;
		} finally {
			// 记录和税控系统交互接口消息
			logCallSk(dsBean.getCreateOpId(), dsBean.getCreateOrgId(), dsBean.getSharding(), requestMessage,
					responseMessage);
		}

	}

	@Override
	public BOInvoiceDsDtlBean[] queryEInvoiceDsDtlByDsId(long dsId, String regionId, String billCycle)
			throws Exception {
		String sharding = regionId + "_" + billCycle;
		return EInvoiceFactory.getIEInvoiceDAO().getInvoiceDsDtlByDsId(dsId, sharding);
	}

	/**
	 * 请求税控平台开具电子发票
	 *
	 * @throws Exception
	 */
	private SkResponseMsg requestRedEInvoice(BOInvoiceInstBean inst) throws Exception {
		// 组装消息
		String requestMessage = EInvoiceFactory.getIEInvoiceSkMessageBuilder().buildSkRedMsg(inst);
		// 调用税控系统电子发票冲红接口
		String responseMessage = EInvoiceFactory.getISkClientSV().issuingInvoiceRed(requestMessage);
		// 处理回复的消息
		try {
			SkResponseMsg skReturnMsg = EInvoiceFactory.getIEInvoiceMessageParser().parseSkReturn(responseMessage);
			return skReturnMsg;
		} catch (Exception e) {
			throw e;
		} finally {
			// 记录和税控系统交互接口消息
			logCallSk(inst.getCreateOpId(), inst.getCreateOrgId(), inst.getSharding(), requestMessage, responseMessage);
		}
	}

	/**
	 * @throws Exception
	 */
	private void logCallSk(long createOpId, long createOrgId, String sharding, String requestMessage,
			String skReturnMsg) throws Exception {
		final BOInvoiceMsgLogBean log = new BOInvoiceMsgLogBean();
		log.setCreateOpId(createOpId);
		log.setCreateOrgId(createOrgId);
		log.setSharding(sharding);
		log.setMessageKey("");
		log.setMessageKeyType("");
		log.setMessageType("SK");
		// 处理请求报文
		DataModelUtil.dealLargeParam(log, "REQ_CONTENT", requestMessage);
		// 处理返回报文
		DataModelUtil.dealLargeParam(log, "RES_CONTENT", skReturnMsg);
		// 入表，使用独立事务
		DataModelUtil.dependTransaction(new ExecuteEvent() {
			@Override
			public void execute() throws Exception {
				EInvoiceFactory.getIEInvoiceDAO().saveInvoiceMsgLog(log);
			}
		});
	}

	/**
	 * 发票数据合法性校验接口，校验数据是否合法
	 *
	 * @version: v1.0.0
	 */
	private boolean checkInvoiceDataValid(CrmRequestMsg requestMsgBean) throws Exception {
		InvoiceMsg invoice = requestMsgBean.getInvoiceMsg();
		// CrmRequestMsg.BusiMsg busi = requestMsgBean.getBusiMsg();
		InvoiceItemMsg[] invoiceItems = requestMsgBean.getInvoiceItemMsgs();
		// 校验发票数据源编号合法性
		if (invoice == null) {
			throw new Exception("发票对象不能为空！");
		}
		// if (StringUtils.isEmptyString(invoiceMap.getSharding)) {
		// throw new Exception("地市不能为空");
		// }

		if (invoice.getCreateOpId() <= 0) {
			throw new Exception("操作员编号:" + invoice.getCreateOpId() + "不合法");
		}
		if (StringUtils.isEmpty(invoice.getKpy())) {
			throw new Exception("操作员名称:" + invoice.getKpy() + "不合法");
		}
		if (invoice.getCreateOrgId() <= 0) {
			throw new Exception("操作员组织编号:" + invoice.getCreateOrgId() + "不合法");
		}
		if (StringUtils.isEmpty(invoice.getXhfNsrsbh())) {
			throw new Exception("销货方纳税人识别号:" + invoice.getXhfNsrsbh() + " 不合法");
		}
		if (StringUtils.isEmpty(invoice.getXhfNsrmc())) {
			throw new Exception("销货方纳税人名称:" + invoice.getXhfNsrmc() + " 不合法");
		}
		if (StringUtils.isEmpty(invoice.getXhfDz())) {
			throw new Exception("销货方地址:" + invoice.getXhfDz() + " 不合法");
		}
		if (StringUtils.isEmpty(invoice.getXhfDhhm())) {
			throw new Exception("销货方电话:" + invoice.getXhfDhhm() + " 不合法");
		}
		if (!EInvoiceUtil.isInteger(invoice.getDkbz()) || Integer.parseInt(invoice.getDkbz()) < 0) {
			throw new Exception("代开标志:" + invoice.getDkbz() + " 不合法");
		}
		if (StringUtils.isEmpty(invoice.getGhfNsrmc())) {
			throw new Exception("购货方纳税人名称:" + invoice.getGhfNsrmc() + " 不合法");
		}
		if (!EInvoiceUtil.isInteger(invoice.getGhfQylx())) {
			throw new Exception("购货方企业类型:" + invoice.getGhfQylx() + " 不合法");
		}

		// 校验发票明细是否合法
		if (ArrayUtils.isEmpty(invoiceItems)) {
			throw new Exception("明细数据不正确：明细记录为空，请至少包含一条明细数据");
		} else {
			for (InvoiceItemMsg detail : invoiceItems) {
				if (StringUtils.isEmpty(detail.getItemName())) {
					throw new Exception("发票明细数据不正确：项目名称不能为空");
				}
				if (detail.getItemPrice() == 0) {
					throw new Exception("发票明细数据不正确：数据明细单价不能为0");
				}
				if (detail.getItemNumb() == 0) {
					throw new Exception("发票明细数据不正确：数据明细数量不能为0");
				}
				if (detail.getItemAmount() == 0) {
					throw new Exception("发票明细数据不正确：数据明细中金额不能为0");
				}
				if (detail.getItemFaxRate() <= 0) {
					throw new Exception("发票明细数据不正确：税率不能为空");
				}

				if (!EInvoiceUtil.isInteger(detail.getHxbz()) || Integer.parseInt(detail.getHxbz()) < 0) {
					throw new Exception("发票明细数据不正确：含税标志：" + detail.getHxbz() + "不合法");
				}
			}
		}
		// X 校验发票业务关联数据是否合法

		return true;
	}

	@Override
	public BOInvoiceDsPushReqBean[] queryEInvoiceDsPushReqs(long dsId, String regionId, String billCycle)
			throws Exception {
		String sharding = regionId + "_" + billCycle;
		return EInvoiceFactory.getIEInvoiceDAO().queryEInvoiceDsPushReqs(dsId, sharding);
	}

}
