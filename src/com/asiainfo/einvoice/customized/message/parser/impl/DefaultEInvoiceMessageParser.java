package com.asiainfo.einvoice.customized.message.parser.impl;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.einvoice.core.def.DataDescription;
import com.asiainfo.einvoice.core.def.ReturnStateInfo;
import com.asiainfo.einvoice.core.def.SkResponseMsg;
import com.asiainfo.einvoice.core.def.SkReturnMsg;
import com.asiainfo.einvoice.customized.message.parser.interfaces.IEInvoiceMessageParser;
import com.asiainfo.einvoice.util.EInvoiceUtil;
import com.asiainfo.einvoice.util.TripleDESUtil;
import com.asiainfo.einvoice.util.XmlUtil;

public class DefaultEInvoiceMessageParser implements IEInvoiceMessageParser {

	@Override
	public SkResponseMsg parseSkReturn(String message) throws Exception {
		if (StringUtils.isBlank(message)) {
			throw new Exception("没有收到任何内容！");
		}
		String encoding = "".equals(EInvoiceUtil.getElecInvoiceStatic("encoding")) ? "utf-8"
				: EInvoiceUtil.getElecInvoiceStatic("encoding");

		SkReturnMsg msg = XmlUtil.fromXml(message, SkReturnMsg.class);
		ReturnStateInfo info = msg.getReturnStateInfo();
		String returnCode = info.getReturnCode();
		if ("0000".equals(info.getReturnCode()) || "0".equals(info.getReturnCode())) {
			DataDescription dd = msg.getData().getDataDescription();
			String content = msg.getData().getContent();
			// 1.base64解密
			byte[] contentBytes = EInvoiceUtil.base64DecodeBytes(content, encoding);
			// 2.ZIP解压缩
			if ("1".equals(dd.getZipCode())) {
				contentBytes = EInvoiceUtil.decompress(contentBytes);
			}
			// 1.3DES解密
			if ("1".equals(dd.getEncryptCode())) {
				String secretKey = msg.getGlobalInfo().getPassWord();
				secretKey = secretKey.substring(10);
				// String secretKey =
				// ElecInvoiceUtil.getElecInvoiceStatic("secret_key"); //密钥
				contentBytes = TripleDESUtil.decryptMode(secretKey.getBytes(encoding), contentBytes);
			}
			content = new String(contentBytes, encoding);
			return XmlUtil.fromXml(content, SkResponseMsg.class);
		}
		return null;
	}

}
