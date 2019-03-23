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
		// 1��У������������
		checkInvoiceDataValid(crmRequestMsg);
		// ����Ƿ��Ѿ�����Ʊ������ֽ�ʷ�Ʊ��
		if (hasIssuingRecord(crmRequestMsg)) {
			throw new Exception("�Ѿ����߹���Ʊ�������ظ�����");
		}
		String sharding = regionId + "_" + billCycle;

		// 2�����ɵ��ӷ�Ʊ����Դ����
		InvoiceDsBean invoiceDsAll = generatorEInvoiceDs(crmRequestMsg, sharding, false);

		BOInvoiceDsBean dsBean = invoiceDsAll.getInvoiceDsValue();
		BOInvoiceDsDtlBean[] dsItemBeans = invoiceDsAll.getInvoiceDsDtlValues();

		// 3������˰��ƽ̨���ߵ��ӷ�Ʊ
		SkResponseMsg skReturnMsg = requestIssuingEInvoice(dsBean, dsItemBeans);

		// 5�����ɵ��ӷ�Ʊ���߼�¼
		BOInvoiceInstBean inst = generatorEInvoiceRecord(null, dsBean, skReturnMsg, sharding);

		dsBean.setDsState(EInvoiceConst.Dstate.ISSUING);
		EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDs(dsBean);

		// 6��˰�ؽӿڷ��سɹ���������Ʊ���߳ɹ����ļ��������쳣��Ӱ���������߷���
		boolean isPdfSuccess = persistentEInvoiceInst(inst, skReturnMsg);

		// pdf�ļ��־û��ɹ�,�����Ҫ���ͣ����������͹������������ļ��־û��ɹ�������
		if (isPdfSuccess) {
			createInvoicePushTask(invoiceDsAll.getBoInvoiceDsPushReqBeans(), dsBean.getSharding(),
					inst.getInvoiceDsId(), inst.getInvoiceInstanceId());
		}
		return inst.getInvoiceInstanceId();
	}

	public long issuingEInvoiceAsync(CrmRequestMsg crmRequestMsg, String regionId, String billCycle) throws Exception {
		// 1��У������������
		checkInvoiceDataValid(crmRequestMsg);
		// ����Ƿ��Ѿ�����Ʊ������ֽ�ʷ�Ʊ��
		if (hasIssuingRecord(crmRequestMsg)) {
			throw new Exception("�Ѿ����߹���Ʊ�������ظ�����");
		}
		String sharding = CenterFactory.getCenterInfo().getRegion();

		// 2�����ɵ��ӷ�Ʊ����Դ����
		InvoiceDsBean invoiceDsAll = generatorEInvoiceDs(crmRequestMsg, sharding, false);

		BOInvoiceDsBean dsBean = invoiceDsAll.getInvoiceDsValue();
		BOInvoiceDsDtlBean[] dsItemBeans = invoiceDsAll.getInvoiceDsDtlValues();

		// 3������˰��ƽ̨���ߵ��ӷ�Ʊ
		SkResponseMsg skReturnMsg = requestIssuingEInvoice(dsBean, dsItemBeans);
		String code = skReturnMsg.getReturnCode();
		//
		if ("0000".equals(code) || "0".equals(code)) {
			// TODO:ͨ���첽�����󹤵�
		} else {
			throw new Exception(skReturnMsg.getReturnMsg());
		}
		return dsBean.getInvoiceDsId();
	}

	public void issuingEInvoiceBatch(CrmRequestMsg crmRequestMsg, String regionId, String billCycle) throws Exception {
		// �½��Զ�����ʱʹ������ӿڣ�ͨ��dispatch�������߲���
		// 1��У������������
		checkInvoiceDataValid(crmRequestMsg);

		// 2������Ƿ��Ѿ�����Ʊ������ֽ�ʷ�Ʊ��
		if (hasIssuingRecord(crmRequestMsg)) {
			throw new Exception("�Ѿ����߹���Ʊ�������ظ�����");
		}
		String sharding = regionId + "_" + billCycle;
		// 3�����ɵ��ӷ�Ʊ����Դ����
		generatorEInvoiceDs(crmRequestMsg, sharding, true);
	}

	public void issuingEInvoiceBatchDisaptch(long invoiceDsId, String regionId, String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;

		BOInvoiceDsBean ds = queryEInvoiceDsByDsId(invoiceDsId, regionId, billCycle);
		if (ds == null || ds.isNew()) {
			throw new RuntimeException("��������Դid��" + invoiceDsId + "û���ҵ����ڵ����ݣ�");
		}
		BOInvoiceDsDtlBean[] dtls = EInvoiceFactory.getIEInvoiceSV().queryEInvoiceDsDtlByDsId(invoiceDsId, regionId,
				billCycle);
		BOInvoiceDsPushReqBean[] boInvoiceDsPushReqBeans = EInvoiceFactory.getIEInvoiceDAO()
				.queryEInvoiceDsPushReqs(invoiceDsId, sharding);

		// ����Ƿ��Ѿ�����Ʊ������ֽ�ʷ�Ʊ��
		boolean is = EInvoiceFactory.getIssuingChecker().beforCheck(ds, dtls);
		if (is) {
			throw new Exception("�Ѿ����߹���Ʊ�������ظ�����");
		}
		// 3������˰��ƽ̨���ߵ��ӷ�Ʊ
		SkResponseMsg skReturnMsg = requestIssuingEInvoice(ds, dtls);

		// 5�����ɵ��ӷ�Ʊ���߼�¼
		BOInvoiceInstBean inst = generatorEInvoiceRecord(null, ds, skReturnMsg, sharding);
		ds.setDsState(EInvoiceConst.Dstate.ISSUING);
		EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDs(ds);
		// 6��˰�ؽӿڷ��سɹ���������Ʊ���߳ɹ����ļ��������쳣��Ӱ���������߷���
		boolean isPdfSuccess = persistentEInvoiceInst(inst, skReturnMsg);

		// pdf�ļ��־û��ɹ�,�����Ҫ���ͣ����������͹������������ļ��־û��ɹ�������
		if (isPdfSuccess) {
			createInvoicePushTask(boInvoiceDsPushReqBeans, sharding, inst.getInvoiceDsId(),
					inst.getInvoiceInstanceId());
		}
	}

	public long issuingEInvoiceRed(CrmRequestMsg crmRequestMsg, String regionId, String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;
		// 1�����ӷ�Ʊ���߼�¼��ѯ
		InvoiceMsg msg = crmRequestMsg.getInvoiceMsg();
		long insId = msg.getInvoiceInsId();
		// 2����ѯ��Ʊʵ��
		BOInvoiceInstBean inst = EInvoiceFactory.getIEInvoiceDAO().getInvoiceInsById(insId, sharding);
		if (inst == null) {
			throw new RuntimeException("���ݵ��ӷ�Ʊʵ��id��" + insId + "û���ҵ���Ʊʵ����");
		}
		// 3����֤�Ƿ��Ѿ��й�����¼
		if (hasRedRecord(inst.getInvoiceDsId(), sharding)) {
			throw new Exception("�Ѿ������÷�Ʊ�������ٴγ�죡");
		}
		// 4������˰��ƽ̨�����ӷ�Ʊ
		SkResponseMsg skReturnMsg = requestRedEInvoice(inst);
		// 5�����ɵ��ӷ�Ʊ���߼�¼
		BOInvoiceDsBean ds = EInvoiceFactory.getIEInvoiceDAO().getInvoiceDsById(inst.getInvoiceDsId(), sharding);
		BOInvoiceInstBean redInst = generatorEInvoiceRecord(inst, ds, skReturnMsg, sharding);

		// 6:����ԭ��Ʊʵ��
		inst.setIssuingFlag(EInvoiceConst.IssuingFlag.HAS_RED);
		EInvoiceFactory.getIEInvoiceDAO().saveInvoiceInst(inst);

		ds.setDsState(EInvoiceConst.Dstate.ISSUING_RED);
		EInvoiceFactory.getIEInvoiceDAO().saveInvoiceDs(ds);

		// 7���־û�PDF�ļ�
		// ˰�ؽӿڷ��سɹ���������Ʊ���߳ɹ����ļ��������쳣��Ӱ���������߷���
		boolean isPdfSuccess = persistentEInvoiceInst(redInst, skReturnMsg);
		if (isPdfSuccess) {
			// ��췢Ʊ���������͹���
			// createInvoicePushTask(crmRequestMsg.getPushInfos(),
			// ds.getSharding(), inst.getInvoiceInstanceId());
		}
		return redInst.getInvoiceInstanceId();
	}

	private boolean hasIssuingRecord(CrmRequestMsg msg) throws Exception {
		// ����Դ
		BOInvoiceDsBean ds = DataModelUtil.convertBean2Dc(msg.getInvoiceMsg(), BOInvoiceDsBean.class);
		InvoiceItemMsg[] items = msg.getInvoiceItemMsgs();

		// ����Դ����
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
	 * �Ƿ��Ѿ����߳�췢Ʊ
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
		// ��������ͣ������ɹ���
		if (!ArrayUtils.isEmpty(dsPushReqBeans)) {
			for (BOInvoiceDsPushReqBean info : dsPushReqBeans) {
				if (EInvoiceConst.PushWay.NO.equals(info.getPushWay())) {
					return;
				}
				// ���ȫ�����ͣ���Ҫ���ɶ��Ź���
				createInvoicePushTask(sharding, invoiceDsId, invoiceInsId, info.getPushWay(), info.getPushTarget());
			}
		}
	}

	/*
	 * �������͹���
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
		// ��ȡ˰�ز�ѯ����ģ��
		XmlTemplateEngine engine = EInvoiceTemplateProvider.getSkQueryReqXmlEngine();
		// ���ò���
		engine.setParams(inst);
		// ��Ⱦ����
		String queryMsg = engine.render();
		// ��ȡ˰�ؿͻ���
		ISkClientSV client = EInvoiceFactory.getISkClientSV();
		// ���ò�ѯ��Ʊ�ӿ�
		String rtn = client.queryInvoice(queryMsg);
		// ��ȡ��Ϣ������
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
		// ��ȡ���͹���
		IBOInvoicePushTaskValue task = EInvoiceFactory.getIEInvoiceDAO().getInvoicePusherTaskByTaskId(pushTaskId,
				sharding);
		// ������͹�����Ϊ��
		if (task != null) {
			// ���ͷ�ʽ
			String pushWay = task.getPushWay();
			// ��ȡ���ͽӿ�
			IEInvoiceMessagePusher pusher = EInvoiceFactory.getIEInvoiceMessagePusher(pushWay);
			// ����
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
		// ��ȡ���͹���
		IBOInvoicePushTaskValue task = new BOInvoicePushTaskBean();
		task.setInvoiceInstanceId(invoiceInstId);
		// ��ȡ���ͽӿ�
		IEInvoiceMessagePusher pusher = EInvoiceFactory.getIEInvoiceMessagePusher(pushWay);
		// ����
		pusher.push(task);
	}

	@Override
	public void fjNofity(String billId, long custId, long userId, long acctId, String regionId) throws Exception {
		BOMonthlyAutoCustomizeBean monthly = EInvoiceFactory.getIEInvoiceDAO().getMonthlyAutoCustomize(billId, custId,
				userId, acctId, regionId);
		if (monthly != null) {
			// ���Ȳ鿴�Ƿ���֮ǰ��Ϊ����Ʊ
			String mark = monthly.getPreIssuingMark();
			String[] cycle = null;
			if (StringUtils.isNotBlank(mark)) {
				// ͨ��mark����Ƿ�ѵ��·ݣ�����
				cycle = calcArrearTime(mark);
				//
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
				cycle = new String[] { format.format(new Date()) };
			}
			if (!ArrayUtils.isEmpty(cycle)) {
				for (String c : cycle) {
					// ���������ã���ָ��½���÷���
					if (isArrears(monthly, c)) {
						// �����˹ܽӿڣ���ѯ�û��ķ�Ʊ��Ϣ
						CrmRequestMsg msg = EInvoiceFactory.getIAmsClientSV().queryInvoiceData(monthly.getCustId(),
								monthly.getUserId(), monthly.getAcctId(), monthly.getBillId(), regionId, c);
						EInvoiceFactory.getIEInvoiceSV().issuingEInvoiceBatch(msg, regionId, c);
					} else {
						// �����δ�����˵�����Ҫ��δ��Ʊʱ���¼�������ȴ��´ο�Ʊʱ�ж�
						if (com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils
								.isBlank(monthly.getPreIssuingMark())) {
							SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
							monthly.setPreIssuingMark(format.format(new Date()));
						}
						// ��¼δ��Ʊ����
						EInvoiceFactory.getIEInvoiceDAO().saveMonthlyAutoCustomize(monthly);
					}
				}
			}
		}
	}

	// ��Ʊ֮ǰ����û��Ƿ�Ƿ�ѡ�
	private boolean isArrears(BOMonthlyAutoCustomizeBean monthly, String cycle) throws Exception {
		return EInvoiceFactory.getIAmsClientSV().isUserArrears(monthly.getCustId(), monthly.getUserId(),
				monthly.getAcctId(), monthly.getBillId(), monthly.getSharding(), cycle);
	}

	private String[] calcArrearTime(String mark) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date date = format.parse(mark);
		// this month
		Calendar cal = Calendar.getInstance();
		// ���������·���
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
			// ��ȡ�ļ��ַ���������
			ByteArrayInputStream inputStream = new ByteInputStream();
			inputStream.read(msg.getPdfFile().getBytes());
			// �ϴ��ļ�
			InvoiceFileInfo file = EInvoiceFactory.getIEInvoiceFileSV().upload(inst.getInvoiceInstanceId(),
					inputStream);
			// ���
			// ����Ʊʵ�������ļ�ʵ����
			BOInvoicePresInstBean pres = DataModelUtil.mixDc(BOInvoicePresInstBean.class, inst);
			// ���ļ���Ϣ�����ļ�ʵ����
			DataModelUtil.insertBean2Dc(file, pres);
			// �����ļ���Ϣ
			EInvoiceFactory.getIEInvoiceDAO().saveInvoicePresInst(pres);
			return true;
		} catch (Exception e) {
			logger.error("���ӷ�Ʊpdf�ļ��־û�ʧ��(��Ӱ�췢Ʊ���߳ɹ����)," + e.getMessage(), e);
			// ���ñ�־or�ܹ����pdf�ļ��־�ʧ��
			// ���������
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
				// ���ȱ��¼ʧ�ܲ�Ӱ���������̣���PDF�ϴ����ڵ�һ�β�ѯ��ʱ��
				logger.error("��¼�ļ��ϴ�����ʧ��(��Ӱ�췢Ʊ���߳ɹ����)," + e.getMessage(), e);
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
		// ͨ���ļ���¼�����ļ�
		if (inst != null) {
			return EInvoiceFactory.getIEInvoiceFileSV().download(inst);
		} else {
			throw new Exception("δ�ҵ��ļ���¼��");
		}

	}

	@Override
	public IBOInvoiceDsValue[] queryEInvoiceDs(String busiType, Map<String, ?> conditionVal, Map<String, ?> conditionOp,
			String regionId, String billCycle) throws Exception {
		String sharding = regionId + "_" + billCycle;
		IBOInvoiceDsValue[] rtn = null;
		// ͨ��ҵ�񳡾��ҵ���Ӧ������ԴID
		IBOBusiFeatureRelDefValue[] defs = EInvoiceFactory.getIEInvoiceDAO().getBusiFeatureRelDefByBusiType(busiType);
		if (!ArrayUtils.isEmpty(defs)) {
			// ӳ���ֶ�
			Map<String, String> fields = new HashMap();
			for (IBOBusiFeatureRelDefValue def : defs) {
				String field = def.getFeatureField();
				fields.put(def.getFeatureCode().toUpperCase(), field);
			}
			BOInvoiceBusiFeatureBean def = new BOInvoiceBusiFeatureBean();
			// ��ȡSQLģ������
			SqlTemplateEngine engine = EInvoiceTemplateProvider.getSqlTemplateEngine();
			// ���ñ���
			engine.setTableName(def.fetchTableName());
			// ƴд����
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
			// ͨ��SQL��ѯ
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
	 * ���ɵ��ӷ�Ʊ����Դ����
	 *
	 * @param crmRequestMsg
	 * @param isDispatch
	 *            �Ƿ���������Դ����ʵ��
	 * @return
	 * @throws Exception
	 */
	private InvoiceDsBean generatorEInvoiceDs(CrmRequestMsg crmRequestMsg, String sharding, boolean isDispatch)
			throws Exception {
		InvoiceDsBean bean = new InvoiceDsBean();
		// 1������Դʵ������
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
		// 2������Դʵ�����Դ���
		Map invoiceAttrMap = crmRequestMsg.getInvoiceMsg().getAttributeMap();
		if (invoiceAttrMap != null) {
			// TODO:
		}
		// 3������Դʵ��ҵ����������
		IBOInvoiceBusiFeatureValue feature = null;
		BusiMsg busi = crmRequestMsg.getBusiMsg();
		if (busi != null) {
			feature = DataModelUtil.convertBean2Dc(busi, BOInvoiceBusiFeatureBean.class);
			// ע������Դ
			feature.setInvoiceDsId(invoiceDsId);
			feature.setSharding(sharding);
			// ��������
			EInvoiceFactory.getIEInvoiceDAO().saveInvoiceBusiFeature(feature);
		}

		// 4������Դʵ����Ŀ��ϸ����
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

		// 5������Դ����������
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

		// 6������Դ����ʵ������
		if (isDispatch) {
			// ������ȱ�
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
	 * ���ɵ��ӷ�Ʊ��¼
	 *
	 * @return
	 * @throws Exception
	 */
	private BOInvoiceInstBean generatorEInvoiceRecord(BOInvoiceInstBean oldInst, BOInvoiceDsBean dsBean,
			SkResponseMsg returnMsg, String sharding) throws Exception {
		// ����˰�ط�����Ϣ
		BOInvoiceInstBean inst = DataModelUtil.mixBean2Dc(BOInvoiceInstBean.class, returnMsg);
		// ����DS����Դ
		DataModelUtil.mixDc(inst, dsBean);

		inst.setIssuingType(EInvoiceConst.IssuingType.E_INVOICE);
		if (oldInst != null) {
			// ��д�����ķ�Ʊ����
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
		// ���淢Ʊ����
		long instId = EInvoiceFactory.getIEInvoiceDAO().saveInvoiceInst(inst);

		// ��ʵ��ID���inst
		inst.setInvoiceInstanceId(instId);
		// ��������
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
	 * ����˰��ƽ̨���ߵ��ӷ�Ʊ
	 *
	 * @throws Exception
	 */
	private SkResponseMsg requestIssuingEInvoice(BOInvoiceDsBean dsBean, BOInvoiceDsDtlBean[] dsItemBeans)
			throws Exception {
		// ��װ��Ϣ
		String requestMessage = EInvoiceFactory.getIEInvoiceSkMessageBuilder().buildSkIssuingMsg(dsBean, dsItemBeans);
		// ����˰��ϵͳ���ӷ�Ʊ���߽ӿ�
		String responseMessage = EInvoiceFactory.getISkClientSV().issuingInvoice(requestMessage);
		// ����ظ�����Ϣ
		try {
			SkResponseMsg skReturnMsg = EInvoiceFactory.getIEInvoiceMessageParser().parseSkReturn(responseMessage);
			return skReturnMsg;
		} catch (Exception e) {
			throw e;
		} finally {
			// ��¼��˰��ϵͳ�����ӿ���Ϣ
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
	 * ����˰��ƽ̨���ߵ��ӷ�Ʊ
	 *
	 * @throws Exception
	 */
	private SkResponseMsg requestRedEInvoice(BOInvoiceInstBean inst) throws Exception {
		// ��װ��Ϣ
		String requestMessage = EInvoiceFactory.getIEInvoiceSkMessageBuilder().buildSkRedMsg(inst);
		// ����˰��ϵͳ���ӷ�Ʊ���ӿ�
		String responseMessage = EInvoiceFactory.getISkClientSV().issuingInvoiceRed(requestMessage);
		// ����ظ�����Ϣ
		try {
			SkResponseMsg skReturnMsg = EInvoiceFactory.getIEInvoiceMessageParser().parseSkReturn(responseMessage);
			return skReturnMsg;
		} catch (Exception e) {
			throw e;
		} finally {
			// ��¼��˰��ϵͳ�����ӿ���Ϣ
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
		// ����������
		DataModelUtil.dealLargeParam(log, "REQ_CONTENT", requestMessage);
		// �����ر���
		DataModelUtil.dealLargeParam(log, "RES_CONTENT", skReturnMsg);
		// ���ʹ�ö�������
		DataModelUtil.dependTransaction(new ExecuteEvent() {
			@Override
			public void execute() throws Exception {
				EInvoiceFactory.getIEInvoiceDAO().saveInvoiceMsgLog(log);
			}
		});
	}

	/**
	 * ��Ʊ���ݺϷ���У��ӿڣ�У�������Ƿ�Ϸ�
	 *
	 * @version: v1.0.0
	 */
	private boolean checkInvoiceDataValid(CrmRequestMsg requestMsgBean) throws Exception {
		InvoiceMsg invoice = requestMsgBean.getInvoiceMsg();
		// CrmRequestMsg.BusiMsg busi = requestMsgBean.getBusiMsg();
		InvoiceItemMsg[] invoiceItems = requestMsgBean.getInvoiceItemMsgs();
		// У�鷢Ʊ����Դ��źϷ���
		if (invoice == null) {
			throw new Exception("��Ʊ������Ϊ�գ�");
		}
		// if (StringUtils.isEmptyString(invoiceMap.getSharding)) {
		// throw new Exception("���в���Ϊ��");
		// }

		if (invoice.getCreateOpId() <= 0) {
			throw new Exception("����Ա���:" + invoice.getCreateOpId() + "���Ϸ�");
		}
		if (StringUtils.isEmpty(invoice.getKpy())) {
			throw new Exception("����Ա����:" + invoice.getKpy() + "���Ϸ�");
		}
		if (invoice.getCreateOrgId() <= 0) {
			throw new Exception("����Ա��֯���:" + invoice.getCreateOrgId() + "���Ϸ�");
		}
		if (StringUtils.isEmpty(invoice.getXhfNsrsbh())) {
			throw new Exception("��������˰��ʶ���:" + invoice.getXhfNsrsbh() + " ���Ϸ�");
		}
		if (StringUtils.isEmpty(invoice.getXhfNsrmc())) {
			throw new Exception("��������˰������:" + invoice.getXhfNsrmc() + " ���Ϸ�");
		}
		if (StringUtils.isEmpty(invoice.getXhfDz())) {
			throw new Exception("��������ַ:" + invoice.getXhfDz() + " ���Ϸ�");
		}
		if (StringUtils.isEmpty(invoice.getXhfDhhm())) {
			throw new Exception("�������绰:" + invoice.getXhfDhhm() + " ���Ϸ�");
		}
		if (!EInvoiceUtil.isInteger(invoice.getDkbz()) || Integer.parseInt(invoice.getDkbz()) < 0) {
			throw new Exception("������־:" + invoice.getDkbz() + " ���Ϸ�");
		}
		if (StringUtils.isEmpty(invoice.getGhfNsrmc())) {
			throw new Exception("��������˰������:" + invoice.getGhfNsrmc() + " ���Ϸ�");
		}
		if (!EInvoiceUtil.isInteger(invoice.getGhfQylx())) {
			throw new Exception("��������ҵ����:" + invoice.getGhfQylx() + " ���Ϸ�");
		}

		// У�鷢Ʊ��ϸ�Ƿ�Ϸ�
		if (ArrayUtils.isEmpty(invoiceItems)) {
			throw new Exception("��ϸ���ݲ���ȷ����ϸ��¼Ϊ�գ������ٰ���һ����ϸ����");
		} else {
			for (InvoiceItemMsg detail : invoiceItems) {
				if (StringUtils.isEmpty(detail.getItemName())) {
					throw new Exception("��Ʊ��ϸ���ݲ���ȷ����Ŀ���Ʋ���Ϊ��");
				}
				if (detail.getItemPrice() == 0) {
					throw new Exception("��Ʊ��ϸ���ݲ���ȷ��������ϸ���۲���Ϊ0");
				}
				if (detail.getItemNumb() == 0) {
					throw new Exception("��Ʊ��ϸ���ݲ���ȷ��������ϸ��������Ϊ0");
				}
				if (detail.getItemAmount() == 0) {
					throw new Exception("��Ʊ��ϸ���ݲ���ȷ��������ϸ�н���Ϊ0");
				}
				if (detail.getItemFaxRate() <= 0) {
					throw new Exception("��Ʊ��ϸ���ݲ���ȷ��˰�ʲ���Ϊ��");
				}

				if (!EInvoiceUtil.isInteger(detail.getHxbz()) || Integer.parseInt(detail.getHxbz()) < 0) {
					throw new Exception("��Ʊ��ϸ���ݲ���ȷ����˰��־��" + detail.getHxbz() + "���Ϸ�");
				}
			}
		}
		// X У�鷢Ʊҵ����������Ƿ�Ϸ�

		return true;
	}

	@Override
	public BOInvoiceDsPushReqBean[] queryEInvoiceDsPushReqs(long dsId, String regionId, String billCycle)
			throws Exception {
		String sharding = regionId + "_" + billCycle;
		return EInvoiceFactory.getIEInvoiceDAO().queryEInvoiceDsPushReqs(dsId, sharding);
	}

}
