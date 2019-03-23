package com.asiainfo.einvoice.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.asiainfo.einvoice.core.EInvoiceFactory;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;

/**
 * Created by huangjh on 16/3/30.
 */
public class EInvoiceFileHelper {
	private long invoiceInsId = -1;
	private String sharding = "";

	private EInvoiceFileHelper(long invoiceInsId, String sharding) {
		this.invoiceInsId = invoiceInsId;
		this.sharding = sharding;
	}

	public static EInvoiceFileHelper getInstance(long invoiceInsId, String sharding) {
		return new EInvoiceFileHelper(invoiceInsId, sharding);
	}

	public InputStream getEInvoiceFile() throws Exception {
		// 通过InvoiceInsId获取
		IBOInvoicePresInstValue pres = EInvoiceFactory.getIEInvoiceDAO().getInvoicePresInstByInvInsId(invoiceInsId,
				sharding);
		return EInvoiceFactory.getIEInvoiceFileSV().download(pres);
	}

	/**
	 * 下载的文件转化为byte数组
	 *
	 * @return
	 * @throws Exception
	 */
	public byte[] getEInvoiceFileBytes() throws Exception {
		InputStream ins = getEInvoiceFile();
		ByteArrayOutputStream ops = new ByteArrayOutputStream();
		int i;
		while ((i = ins.read()) != -1) {
			ops.write(i);
		}
		return ops.toByteArray();
	}

	/**
	 * 下载的文件转化为字符串
	 *
	 * @return
	 * @throws Exception
	 */
	public String getEInvoiceFileString() throws Exception {
		return new String(getEInvoiceFileBytes());
	}

}
