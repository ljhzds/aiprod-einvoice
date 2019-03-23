package com.asiainfo.einvoice.inter.file.interfaces;

import java.io.InputStream;

import com.asiainfo.einvoice.core.def.InvoiceFileInfo;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;

public interface IFileClient {
	/**
	 * ���ӷ�Ʊ�ļ��ϴ���ƽ̨ ����pdf�ļ����ϴ���������ƽ̨������file_id
	 *
	 * @param fileInputStream
	 * @param einvoiceRecordId
	 * @return
	 * @throws Exception
	 */
	public InvoiceFileInfo uploadFile(InputStream fileInputStream, long einvoiceRecordId) throws Exception;

	/**
	 *
	 * @param einvoiceRecordId
	 * @return
	 * @throws Exception
	 */
	public InputStream downloadFile(IBOInvoicePresInstValue inst) throws Exception;
}
