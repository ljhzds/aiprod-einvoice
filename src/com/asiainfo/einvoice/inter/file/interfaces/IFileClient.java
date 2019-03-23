package com.asiainfo.einvoice.inter.file.interfaces;

import java.io.InputStream;

import com.asiainfo.einvoice.core.def.InvoiceFileInfo;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;

public interface IFileClient {
	/**
	 * 电子发票文件上传云平台 根据pdf文件流上传到内容云平台，返回file_id
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
