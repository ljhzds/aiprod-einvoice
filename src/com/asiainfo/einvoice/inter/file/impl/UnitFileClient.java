package com.asiainfo.einvoice.inter.file.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.einvoice.core.def.InvoiceFileInfo;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;
import com.asiainfo.einvoice.inter.file.interfaces.IFileClient;

/**
 * ͳһ���ݹ���ƽ̨
 * <p/>
 * Created by huangjh on 16/3/24.
 */
public class UnitFileClient implements IFileClient {
	@Override
	public InvoiceFileInfo uploadFile(InputStream inputStream, long einvoiceRecordId) throws Exception {
		// �����ļ����ϴ��ļ������ݹ���ƽ̨������file_id
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Map data = new HashMap<String, Object>();
		// try {
		// if (inputStream != null) {
		// String ESB_URL = "";
		// String serviceName = "ESB_BASE_CMS_FILE_UPLOAD_001";
		// String methodName = ESB_URL + "execute";
		//
		// String fileName = invoiceRecordId + ".PDF";
		// BUSI_INFO busiInfo = new BUSI_INFO();
		//
		// busiInfo.setCATALOG_ID(EInvoiceConst.E_INV_CATALOGID);//����ƽ̨�е��ĵ����ID��ʹ��{base_url}/api/catalog��ѯ
		// busiInfo.setBUSI_TYPE(EInvoiceConst.E_INV_BUSITYPE);//���̻�¼�롢�ͻ����ϱ���ȡ����ﴫ���Ϊ���룬�������ݹ���ƽ̨Ԥ������,�ο�
		// ҵ�����ͱ���
		// busiInfo.setBUSI_VALUE(EInvoiceConst.E_INV_BUSIVALUE);//�繤���ţ����ű�ţ��ͻ���ŵ�
		//
		// //����user
		// UserInfoInterface user = ServiceManager.getNewBlankUserInfo();
		// user.setID(20037686);
		// user.setOrgId(0);
		// ServiceManager.setServiceUserInfo(user);
		//
		// String respXml = SoapUtil.invokeMethod(serviceName, methodName,
		// busiInfo);
		//
		// com.asiainfo.crm.common.xbeans.ESB_BASE_CMS_FILE_UPLOAD_001.response.RESP_PARAM
		// resultInfo =
		// (com.asiainfo.crm.common.xbeans.ESB_BASE_CMS_FILE_UPLOAD_001.response.RESP_PARAM)
		// XmlnodelUtil.getBeanFromXml(respXml,
		// com.asiainfo.crm.common.xbeans.ESB_BASE_CMS_FILE_UPLOAD_001.response.RESP_PARAM.class);
		// if
		// (("0").equals(String.valueOf(resultInfo.getPUB_INFO().getRETURN_RESULT())))
		// {
		// String fileId = resultInfo.getBUSI_INFO().getFILE_ID() == null ? null
		// : String.valueOf(resultInfo.getBUSI_INFO().getFILE_ID());
		// String token = resultInfo.getBUSI_INFO().getTOKEN() == null ? null :
		// String.valueOf(resultInfo.getBUSI_INFO().getTOKEN());
		// if (log.isDebugEnabled()) {
		// log.debug("��ѯ�ɹ�");
		// }
		//
		// String url = "http://cms.yw.zj.chinamobile.com";
		// String cacheKey =
		// "X_ELECTRONIC_INVOICE_BASE_PLATFORM";//X_UP_DOWN_BASE_PLATFORM
		// IBOBsParaDetailValue bsParaDetailValue = (BOBsParaDetailBean)
		// CacheFactory
		// .get(BsParaDetailCacheImpl.class, cacheKey);
		// if (bsParaDetailValue != null) {
		// url = bsParaDetailValue.getPara3();
		// }
		// url += "/upload?fileId=" + fileId + "&token=" + token;
		//
		// JSONObject json = new JSONObject();
		//
		// int len = 0;
		// byte[] b = new byte[1024 * 256];
		// while ((len = inputStream.read(b, 0, b.length)) != -1) {
		// baos.write(b, 0, len);
		// }
		// byte[] buffer = baos.toByteArray();
		// String retString = HttpUtils.doPostData(url, fileName,
		// buffer);
		//// log.error("uploadPdfFile retString:" + retString);
		// json = JSONObject.fromObject(retString);
		// String success = (String) json.getString("success");
		// if ("true".equals(success)) {
		// String file_Id = (String) json.getString("fileId");
		// data.put("flag", "true");
		// data.put("file_id", file_Id);
		// } else {
		// String message = (String) json.getString("message");
		//// log.error("�ϴ��ļ�ʧ�ܣ�" + message);
		// data.put("flag", "false");
		// data.put("message", message);
		// }
		//
		// } else {
		// String retMessage = resultInfo.getPUB_INFO()
		// .getRETURN_DESC();
		//// log.error("����ESB�ӿ�ʧ�ܣ�" + retMessage);
		// data.put("flag", "false");
		// data.put("message", retMessage);
		// }
		// }
		// return data;
		// } catch (Exception e) {
		// log.error("uploadPdfFile error:" + e.toString(), e);
		// return data;
		// } finally {
		// if (inputStream != null) {
		// inputStream.close();
		// }
		// if (baos != null) {
		// baos.close();
		// }
		// }
		return null;
	}

	@Override
	public InputStream downloadFile(IBOInvoicePresInstValue inst) throws Exception {
		return null;
	}
}
