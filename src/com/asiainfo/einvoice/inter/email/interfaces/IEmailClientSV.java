package com.asiainfo.einvoice.inter.email.interfaces;

import java.io.InputStream;

public interface IEmailClientSV {
	/**
	 * �ʼ����ͽӿ�
	 * 
	 * @param content
	 *            �ʼ�����
	 * @param pdfFile
	 *            pdf�ļ���
	 * @param mail
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public boolean sendMessage(String content, InputStream pdfFile, String mail) throws Exception;

}
