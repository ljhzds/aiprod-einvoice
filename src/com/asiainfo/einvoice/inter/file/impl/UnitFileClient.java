package com.asiainfo.einvoice.inter.file.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.einvoice.core.def.InvoiceFileInfo;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;
import com.asiainfo.einvoice.inter.file.interfaces.IFileClient;

/**
 * 统一内容管理平台
 * <p/>
 * Created by huangjh on 16/3/24.
 */
public class UnitFileClient implements IFileClient {
	@Override
	public InvoiceFileInfo uploadFile(InputStream inputStream, long einvoiceRecordId) throws Exception {
		// 根据文件流上传文件到内容管理平台，返回file_id
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
		// busiInfo.setCATALOG_ID(EInvoiceConst.E_INV_CATALOGID);//内容平台中的文档类别ID，使用{base_url}/api/catalog查询
		// busiInfo.setBUSI_TYPE(EInvoiceConst.E_INV_BUSITYPE);//如商机录入、客户资料变更等。这里传入的为编码，需在内容管理平台预先设置,参考
		// 业务类型编码
		// busiInfo.setBUSI_VALUE(EInvoiceConst.E_INV_BUSIVALUE);//如工单号，集团编号，客户编号等
		//
		// //设置user
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
		// log.debug("查询成功");
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
		//// log.error("上传文件失败：" + message);
		// data.put("flag", "false");
		// data.put("message", message);
		// }
		//
		// } else {
		// String retMessage = resultInfo.getPUB_INFO()
		// .getRETURN_DESC();
		//// log.error("调用ESB接口失败：" + retMessage);
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
