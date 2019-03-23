package com.asiainfo.einvoice.inter.file.impl;

import java.io.BufferedOutputStream;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;

import com.asiainfo.einvoice.core.def.InvoiceFileInfo;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;
import com.asiainfo.einvoice.inter.file.interfaces.IFileClient;
import com.asiainfo.einvoice.util.EInvoiceConfig;

/**
 * Created by huangjh on 16/3/25.
 */
public class FTPFileClient implements IFileClient {
	private FTPAuthor author;

	public void bind(FTPAuthor validate) throws Exception {
		if (validate != null) {
			this.author = validate;
		}
	}

	public void init() throws Exception {

	}

	public void getConfig() throws Exception {
		String username = EInvoiceConfig.get("FTP.account.username");
		String password = EInvoiceConfig.get("FTP.account.password");
		String path = EInvoiceConfig.get("FTP.account.path");
	}

	public InvoiceFileInfo uploadFile(InputStream fileInputStream, long einvoiceRecordId) throws Exception {
		FTPClient client = new FTPClient();
		BufferedOutputStream bos = null;
		try {
			client.login(this.author.getUsername(), this.author.getPassword());
			client.changeWorkingDirectory(this.author.getWorkPath());
			bos = new BufferedOutputStream(client.getOutputStream());
			int i;
			while ((i = fileInputStream.read()) != -1) {
				bos.write(i);
			}
			bos.flush();
		} catch (Exception e) {
			bos.close();
			throw new Exception(e.getMessage());
		} finally {
			bos.close();
			client.logout();
		}
		return null;
	}

		private String username;
		private String password;
		private String workPath;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getWorkPath() {
			return workPath;
		}

		public void setWorkPath(String workPath) {
			this.workPath = workPath;
		}

		@Override
		public InputStream downloadFile(IBOInvoicePresInstValue inst)
				throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
