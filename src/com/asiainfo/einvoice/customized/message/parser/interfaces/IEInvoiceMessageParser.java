package com.asiainfo.einvoice.customized.message.parser.interfaces;

import com.asiainfo.einvoice.core.def.SkResponseMsg;

/**
 * CRMϵͳ������ӷ�Ʊģ��/ϵͳ����Ϣ�����ӿ�
 * 
 * @author zhanghao
 *
 */
public interface IEInvoiceMessageParser {

	public SkResponseMsg parseSkReturn(String message) throws Exception;
}
