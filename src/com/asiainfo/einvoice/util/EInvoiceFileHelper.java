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
		// ͨ��InvoiceInsId��ȡ
		IBOInvoicePresInstValue pres = EInvoiceFactory.getIEInvoiceDAO().getInvoicePresInstByInvInsId(invoiceInsId,
				sharding);
		return EInvoiceFactory.getIEInvoiceFileSV().download(pres);
	}

	/**
	 * ���ص��ļ�ת��Ϊbyte����
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
	 * ���ص��ļ�ת��Ϊ�ַ���
	 *
	 * @return
	 * @throws Exception
	 */
	public String getEInvoiceFileString() throws Exception {
		return new String(getEInvoiceFileBytes());
	}

}
