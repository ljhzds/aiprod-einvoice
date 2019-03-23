package com.asiainfo.einvoice.customized.message.parser.interfaces;

import com.asiainfo.einvoice.core.def.SkResponseMsg;

/**
 * CRM系统接入电子发票模块/系统，消息解析接口
 * 
 * @author zhanghao
 *
 */
public interface IEInvoiceMessageParser {

	public SkResponseMsg parseSkReturn(String message) throws Exception;
}
