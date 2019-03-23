package com.asiainfo.einvoice.inter.email.interfaces;

import java.io.InputStream;

public interface IEmailClientSV {
	/**
	 * 邮件发送接口
	 * 
	 * @param content
	 *            邮件内容
	 * @param pdfFile
	 *            pdf文件流
	 * @param mail
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public boolean sendMessage(String content, InputStream pdfFile, String mail) throws Exception;

}
