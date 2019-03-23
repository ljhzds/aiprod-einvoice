package com.asiainfo.einvoice.core;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.einvoice.core.dao.interfaces.IEInvoiceDAO;
import com.asiainfo.einvoice.core.service.interfaces.IEInvoiceSV;
import com.asiainfo.einvoice.customized.check.impl.DefaultIssuingChecker;
import com.asiainfo.einvoice.customized.check.interfaces.IIssuingChecker;
import com.asiainfo.einvoice.customized.file.interfaces.IEInvoiceFileSV;
import com.asiainfo.einvoice.customized.message.builder.impl.DefaultEInvoicePusherMsgBuilder;
import com.asiainfo.einvoice.customized.message.builder.impl.DefaultEInvoiceSkMessageBuilder;
import com.asiainfo.einvoice.customized.message.builder.interfaces.IEInvoicePusherMsgBuilder;
import com.asiainfo.einvoice.customized.message.builder.interfaces.IEInvoiceSkMessageBuilder;
import com.asiainfo.einvoice.customized.message.parser.impl.DefaultEInvoiceMessageParser;
import com.asiainfo.einvoice.customized.message.parser.interfaces.IEInvoiceMessageParser;
import com.asiainfo.einvoice.customized.message.pusher.interfaces.IEInvoiceMessagePusher;
import com.asiainfo.einvoice.exception.EInvoiceConfigNotFountExcetion;
import com.asiainfo.einvoice.inter.ams.impl.DefaultAmsClientSVImpl;
import com.asiainfo.einvoice.inter.ams.interfaces.IAmsClientSV;
import com.asiainfo.einvoice.inter.crm.interfaces.IEInvoiceCrmSV;
import com.asiainfo.einvoice.inter.sk.impl.DefaultClientSVImpl;
import com.asiainfo.einvoice.inter.sk.interfaces.ISkClientSV;
import com.asiainfo.einvoice.util.EInvoiceConfig;

public class EInvoiceFactory {

	public static <T> T getService(Class<T> t) throws Exception {
		return (T) ServiceFactory.getService(t);
	}

	public static IIssuingChecker getIssuingChecker() throws Exception {
		return getInstance("check.issuing", DefaultIssuingChecker.class);
	}

	public static ISkClientSV getISkClientSV() throws Exception {
		return getInstance("sk.client.impl", DefaultClientSVImpl.class);
	}

	public static IEInvoiceMessageParser getIEInvoiceMessageParser() throws Exception {
		return getInstance("sk.msg.parser.impl", DefaultEInvoiceMessageParser.class);
	}

	public static IEInvoiceSkMessageBuilder getIEInvoiceSkMessageBuilder() throws Exception {
		return getInstance("sk.msg.builder.impl", DefaultEInvoiceSkMessageBuilder.class);
	}

	public static IEInvoiceFileSV getIEInvoiceFileSV() throws Exception {
		return getInstance("file.client.impl", null);
	}

	/**
	 * �˹ܵ���
	 *
	 * @return
	 * @throws Exception
	 */
	public static IAmsClientSV getIAmsClientSV() throws Exception {
		return getInstance("ams.client.impl", DefaultAmsClientSVImpl.class);
	}

	/**
	 * ��ȡ��������ʵ��
	 *
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static IEInvoiceMessagePusher getIEInvoiceMessagePusher(String type) throws Exception {
		// ��ȡ����������Ϣ
		return getInstance("pusher.impl." + type, null);
	}

	/**
	 * ������Ϣ������
	 *
	 * @return
	 * @throws Exception
	 */
	public static IEInvoicePusherMsgBuilder getIEInvoicePusherMsgBuilder() throws Exception {
		return getInstance("msg.impl.pusher", DefaultEInvoicePusherMsgBuilder.class);
	}

	public static IEInvoiceCrmSV getIEInvoiceCrmSV() throws Exception {
		return getService(IEInvoiceCrmSV.class);
	}

	public static IEInvoiceSV getIEInvoiceSV() throws Exception {
		return getService(IEInvoiceSV.class);
	}

	public static IEInvoiceDAO getIEInvoiceDAO() throws Exception {
		return getService(IEInvoiceDAO.class);
	}

	private static <T> T getInstance(String configName, Class cls) throws Exception {
		String name = EInvoiceConfig.get(configName);
		if (StringUtils.isNotBlank(name)) {
			try {
				return (T) Class.forName(name).newInstance();
			} catch (ClassNotFoundException e) {
				throw new ClassNotFoundException("ʵ����" + name + "ʧ��");
			}
		} else {
			// ���û�����ã����Լ���������ã�ʹ��Ĭ��ʵ��
			if (cls != null) {
				return (T) cls.newInstance();
			} else {
				throw new EInvoiceConfigNotFountExcetion("û������");
			}

		}
	}

}
