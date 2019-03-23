package com.asiainfo.einvoice;

import com.asiainfo.einvoice.util.EInvoiceUtil;

public class EInvoiceConst {
	// 查询的开始账期，固定值为201603，请勿更改
	public static final String E_INV_START_BILLING_CYCLE_ID = EInvoiceUtil.getCodeValue("E_INV_START_BILLING_CYCLE_ID");

	// 从当前月向前查询的账期数
	public static final String E_INV_BILL_MONTH_COUNT = EInvoiceUtil.getCodeValue("E_INV_BILL_MONTH_COUNT");

	/**
	 * 省份编码表-北京
	 */
	public static final String E_INV_PROVINCE_CODE_BEIJING = "100";// 北京
	/**
	 * 省份编码表-上海
	 */
	public static final String E_INV_PROVINCE_CODE_SHANGHAI = "210";// 上海
	/**
	 * 省份编码表-天津
	 */
	public static final String E_INV_PROVINCE_CODE_TIANJIN = "220";// 天津
	/**
	 * 省份编码表-重庆
	 */
	public static final String E_INV_PROVINCE_CODE_CHONGQING = "230";// 重庆
	/**
	 * 省份编码表-贵州
	 */
	public static final String E_INV_PROVINCE_CODE_GUIZHOU = "851";// 贵州
	/**
	 * 省份编码表-湖北
	 */
	public static final String E_INV_PROVINCE_CODE_HUBEI = "270";// 湖北
	/**
	 * 省份编码表-陕西
	 */
	public static final String E_INV_PROVINCE_CODE_SHANXI = "290";// 陕西
	/**
	 * 省份编码表-河北
	 */
	public static final String E_INV_PROVINCE_CODE_HEBEI = "311";// 河北
	/**
	 * 省份编码表-河南
	 */
	public static final String E_INV_PROVINCE_CODE_HENAN = "371";// 河南
	/**
	 * 省份编码表-安徽
	 */
	public static final String E_INV_PROVINCE_CODE_ANHUI = "551";// 安徽
	/**
	 * 省份编码表-福建
	 */
	public static final String E_INV_PROVINCE_CODE_FUJIAN = "591";// 福建
	/**
	 * 省份编码表-青海
	 */
	public static final String E_INV_PROVINCE_CODE_QINGHAI = "971";// 青海
	/**
	 * 省份编码表-甘肃
	 */
	public static final String E_INV_PROVINCE_CODE_GANSU = "931";// 甘肃
	/**
	 * 省份编码表-浙江
	 */
	public static final String E_INV_PROVINCE_CODE_ZHEJIANG = "571";// 浙江
	/**
	 * 省份编码表-海南
	 */
	public static final String E_INV_PROVINCE_CODE_HAINAN = "898";// 海南
	/**
	 * 省份编码表-黑龙江
	 */
	public static final String E_INV_PROVINCE_CODE_HEILONGJIANG = "451";// 黑龙江
	/**
	 * 省份编码表-江苏
	 */
	public static final String E_INV_PROVINCE_CODE_JIANGSU = "250";// 江苏
	/**
	 * 省份编码表-吉林
	 */
	public static final String E_INV_PROVINCE_CODE_JILIN = "431";// 吉林
	/**
	 * 省份编码表-宁夏
	 */
	public static final String E_INV_PROVINCE_CODE_NINGXIA = "951";// 宁夏
	/**
	 * 省份编码表-山东
	 */
	public static final String E_INV_PROVINCE_CODE_SHANDONG = "531";// 山东
	/**
	 * 省份编码表-山西
	 */
	public static final String E_INV_PROVINCE_CODE_SHAN_XI = "351";// 山西
	/**
	 * 省份编码表-新疆
	 */
	public static final String E_INV_PROVINCE_CODE_XINJIANG = "991";// 新疆
	/**
	 * 省份编码表-广东
	 */
	public static final String E_INV_PROVINCE_CODE_GUANGDONG = "200";// 广东
	/**
	 * 省份编码表-辽宁
	 */
	public static final String E_INV_PROVINCE_CODE_LIAONING = "240";// 辽宁
	/**
	 * 省份编码表-广西
	 */
	public static final String E_INV_PROVINCE_CODE_GUANGXI = "771";// 广西
	/**
	 * 省份编码表-湖南
	 */
	public static final String E_INV_PROVINCE_CODE_HUNAN = "731";// 湖南
	/**
	 * 省份编码表-江西
	 */
	public static final String E_INV_PROVINCE_CODE_JIANGXI = "791";// 江西
	/**
	 * 省份编码表-内蒙古
	 */
	public static final String E_INV_PROVINCE_CODE_NEIMENGGU = "471";// 内蒙古
	/**
	 * 省份编码表-云南
	 */
	public static final String E_INV_PROVINCE_CODE_YUNNAN = "871";// 云南
	/**
	 * 省份编码表-四川
	 */
	public static final String E_INV_PROVINCE_CODE_SICHUAN = "280";// 四川
	/**
	 * 省份编码表-西藏
	 */
	public static final String E_INV_PROVINCE_CODE_XIZANG = "891";// 西藏

	/**
	 * 推送渠道
	 */
	public enum PusherType {
		EMail139, SMS;
	}

	public static class CommonState {
		public final static String U = "U";
		public final static String E = "E";
	}

	// 配置类型
	public static class ConfigType {
		// 税控系统消息转换类
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

	// 推送模板方式
	public static class PushWay {
		public final static String NO = "0";// 不推送
		public final static String ALL = "1";// 短信+邮箱
		public final static String SMS = "2";// 短信推送
		public final static String EMAIL = "3";// 邮箱推送
	}

	public static class Dstate {
		public final static String NORMAL = "C";// 初始化
		public final static String ISSUING = "O";// 已开具
		public final static String ISSUING_RED = "X";// 已冲红
	}

	/**
	 * 调度状态
	 */
	public static class DispatchState {
		public final static String CREATE = "C";// 初始化
		public final static String EXCEPTION = "E";// 调度异常
		public final static String OVER = "O";// 调度完成
		public final static String CANCEL = "X";// 取消
	}

	/**
	 * 调度类型
	 */
	public static class DispatchKind {
		public final static String ASYNC_ISSUING = "ASYNC_ISSUING";// 异步开具发票
		public final static String ASYNC_DL_PDF = "ASYNC_DL_PDF";// 异步下载文件
	}

	public static class TaskState {
		public final static String INIT = "I";// 初始化
	}

	public static class IssuingType {
		public final static String E_INVOICE = "1";// 电子发票
	}

	public static class IssuingFlag {
		public final static String NORMAL = "1";// 正常发票
		public final static String HAS_RED = "2";// 已冲红
		public final static String RED = "3";// 红字发票
	}

	public static class InvoiceType {
		public final static String E_USUAL = "1";// 电子通用机打发票
		public final static String E_VAT = "2";// 电子增值税普通发票
		public final static String USUAL = "3";// 通用机打发票
		public final static String VAT_USUAL = "4";// 增值税普通发票
		public final static String VAT_SPEC = "5";// 增值税专用发票
	}

}
