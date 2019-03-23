package com.asiainfo.einvoice;

import com.asiainfo.einvoice.util.EInvoiceUtil;

public class EInvoiceConst {
	// ��ѯ�Ŀ�ʼ���ڣ��̶�ֵΪ201603���������
	public static final String E_INV_START_BILLING_CYCLE_ID = EInvoiceUtil.getCodeValue("E_INV_START_BILLING_CYCLE_ID");

	// �ӵ�ǰ����ǰ��ѯ��������
	public static final String E_INV_BILL_MONTH_COUNT = EInvoiceUtil.getCodeValue("E_INV_BILL_MONTH_COUNT");

	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_BEIJING = "100";// ����
	/**
	 * ʡ�ݱ����-�Ϻ�
	 */
	public static final String E_INV_PROVINCE_CODE_SHANGHAI = "210";// �Ϻ�
	/**
	 * ʡ�ݱ����-���
	 */
	public static final String E_INV_PROVINCE_CODE_TIANJIN = "220";// ���
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_CHONGQING = "230";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_GUIZHOU = "851";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_HUBEI = "270";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_SHANXI = "290";// ����
	/**
	 * ʡ�ݱ����-�ӱ�
	 */
	public static final String E_INV_PROVINCE_CODE_HEBEI = "311";// �ӱ�
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_HENAN = "371";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_ANHUI = "551";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_FUJIAN = "591";// ����
	/**
	 * ʡ�ݱ����-�ຣ
	 */
	public static final String E_INV_PROVINCE_CODE_QINGHAI = "971";// �ຣ
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_GANSU = "931";// ����
	/**
	 * ʡ�ݱ����-�㽭
	 */
	public static final String E_INV_PROVINCE_CODE_ZHEJIANG = "571";// �㽭
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_HAINAN = "898";// ����
	/**
	 * ʡ�ݱ����-������
	 */
	public static final String E_INV_PROVINCE_CODE_HEILONGJIANG = "451";// ������
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_JIANGSU = "250";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_JILIN = "431";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_NINGXIA = "951";// ����
	/**
	 * ʡ�ݱ����-ɽ��
	 */
	public static final String E_INV_PROVINCE_CODE_SHANDONG = "531";// ɽ��
	/**
	 * ʡ�ݱ����-ɽ��
	 */
	public static final String E_INV_PROVINCE_CODE_SHAN_XI = "351";// ɽ��
	/**
	 * ʡ�ݱ����-�½�
	 */
	public static final String E_INV_PROVINCE_CODE_XINJIANG = "991";// �½�
	/**
	 * ʡ�ݱ����-�㶫
	 */
	public static final String E_INV_PROVINCE_CODE_GUANGDONG = "200";// �㶫
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_LIAONING = "240";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_GUANGXI = "771";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_HUNAN = "731";// ����
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_JIANGXI = "791";// ����
	/**
	 * ʡ�ݱ����-���ɹ�
	 */
	public static final String E_INV_PROVINCE_CODE_NEIMENGGU = "471";// ���ɹ�
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_YUNNAN = "871";// ����
	/**
	 * ʡ�ݱ����-�Ĵ�
	 */
	public static final String E_INV_PROVINCE_CODE_SICHUAN = "280";// �Ĵ�
	/**
	 * ʡ�ݱ����-����
	 */
	public static final String E_INV_PROVINCE_CODE_XIZANG = "891";// ����

	/**
	 * ��������
	 */
	public enum PusherType {
		EMail139, SMS;
	}

	public static class CommonState {
		public final static String U = "U";
		public final static String E = "E";
	}

	// ��������
	public static class ConfigType {
		// ˰��ϵͳ��Ϣת����
		public final static String MSG_IMPL_SK = "msg.impl.sk";
		//
		public final static String CLIENT_IMPL_SK = "client.impl.sk";
		public final static String CLIENT_IMPL_EMAIL139 = "client.impl.email139";
		public final static String CLIENT_IMPL_SMS = "client.impl.sms";
		public final static String FILE_CHANNEL = "file.channel";
		public final static String CLIENT_IMPL_FTP = "client.impl.FTP";
		public final static String FTP_ACCOUNT_USERNAME = "FTP.account.username";
		public final static String FTP_ACCOUNT_PASSWORD = "FTP.account.password";
		public final static String FTP_ACCOUNT_PATH = "FTP.account.path";

	}

	// ����ģ�巽ʽ
	public static class PushWay {
		public final static String NO = "0";// ������
		public final static String ALL = "1";// ����+����
		public final static String SMS = "2";// ��������
		public final static String EMAIL = "3";// ��������
	}

	public static class Dstate {
		public final static String NORMAL = "C";// ��ʼ��
		public final static String ISSUING = "O";// �ѿ���
		public final static String ISSUING_RED = "X";// �ѳ��
	}

	/**
	 * ����״̬
	 */
	public static class DispatchState {
		public final static String CREATE = "C";// ��ʼ��
		public final static String EXCEPTION = "E";// �����쳣
		public final static String OVER = "O";// �������
		public final static String CANCEL = "X";// ȡ��
	}

	/**
	 * ��������
	 */
	public static class DispatchKind {
		public final static String ASYNC_ISSUING = "ASYNC_ISSUING";// �첽���߷�Ʊ
		public final static String ASYNC_DL_PDF = "ASYNC_DL_PDF";// �첽�����ļ�
	}

	public static class TaskState {
		public final static String INIT = "I";// ��ʼ��
	}

	public static class IssuingType {
		public final static String E_INVOICE = "1";// ���ӷ�Ʊ
	}

	public static class IssuingFlag {
		public final static String NORMAL = "1";// ������Ʊ
		public final static String HAS_RED = "2";// �ѳ��
		public final static String RED = "3";// ���ַ�Ʊ
	}

	public static class InvoiceType {
		public final static String E_USUAL = "1";// ����ͨ�û���Ʊ
		public final static String E_VAT = "2";// ������ֵ˰��ͨ��Ʊ
		public final static String USUAL = "3";// ͨ�û���Ʊ
		public final static String VAT_USUAL = "4";// ��ֵ˰��ͨ��Ʊ
		public final static String VAT_SPEC = "5";// ��ֵ˰ר�÷�Ʊ
	}

}
