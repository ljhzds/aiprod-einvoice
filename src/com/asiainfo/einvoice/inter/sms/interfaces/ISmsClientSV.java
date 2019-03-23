package com.asiainfo.einvoice.inter.sms.interfaces;

import java.util.Map;

public interface ISmsClientSV {
	/**
	 * 短信发送接口
	 * 
	 * @param content
	 *            短信内容
	 * @param paramter
	 *            参数
	 * @param billId
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public boolean sendMessage(String content, Map paramter, String billId) throws Exception;
}
