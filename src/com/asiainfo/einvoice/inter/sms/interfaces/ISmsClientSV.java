package com.asiainfo.einvoice.inter.sms.interfaces;

import java.util.Map;

public interface ISmsClientSV {
	/**
	 * ���ŷ��ͽӿ�
	 * 
	 * @param content
	 *            ��������
	 * @param paramter
	 *            ����
	 * @param billId
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public boolean sendMessage(String content, Map paramter, String billId) throws Exception;
}
