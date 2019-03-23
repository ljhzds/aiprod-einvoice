package com.asiainfo.einvoice.web;

import com.ai.appframe2.web.action.BaseAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InvoiceFileManagementAction extends BaseAction {
	
	private static transient Log log = LogFactory.getLog(InvoiceFileManagementAction.class);
	
	/**
	 * 电子发票下载、预览
	 * by quanly
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void doGetInvoiceFiles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		Long invoiceID = Long.parseLong(HttpUtil.getAsString(request, "INVOICE_ID"));//发票记录ID
//		String regionID = HttpUtil.getAsString(request, "REGION_ID");//地市
//		Long billMonth = Long.parseLong(HttpUtil.getAsString(request, "BILL_MONTH"));//账期
//		Long isDown = Long.parseLong(HttpUtil.getAsString(request, "IS_DOWN"));//是否下载 0：下载、其他：预览
//		Long isLocal = Long.parseLong(HttpUtil.getAsString(request, "IS_LOCAL"));//是否本地查询 0：是、否则不是（如网厅等）
//		String randomCode = HttpUtil.getAsString(request, "RANDOM_CODE");//随机码（IS_LOCAL不为0时，此值必传）
//
//		if(invoiceID == null){
//			throw new Exception("参数INVOICE_ID不能为空，请传入发票记录id");
//		}
//		if(regionID == null){
//			throw new Exception("参数REGION_ID不能为空，请传入地市");
//		}
//		if(billMonth == null){
//			throw new Exception("参数BILL_MONTH不能为空，请传入发票账期");
//		}
//		if(isDown == null){
//			throw new Exception("参数IS_DOWN不能为空，请选择是否下载，传入 0下载、传入其他值则预览（必须是数字）");
//		}
//		if(isLocal == null){
//			throw new Exception("参数IS_LOCAL不能为空，请选择是否本地查询 0：是、否则不是（必须是数字）");
//		}
//		if(isLocal.longValue() != 0 && (randomCode == null || "".equals(randomCode))){
//			throw new Exception("参数RANDOM_CODE不能为空，请输入随机码");
//		}
//
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
//		URL url = null;
//		HttpURLConnection httpConnection = null;
//		try {
//			// PDF 文件的 MIME 类型
//			response.setContentType( "application/pdf" );
//			//也可以通过下面的方式来设置
//			response.setHeader("Content-type", "application/pdf");
//
//			// 下载模式
//			if(isDown == 0){//是否下载 0：下载、其他：预览
//				response.setHeader("Content-disposition",  "attachment; filename=DZFP"+com.ai.common.util.TimeUtil.getYYYYMMDDHHMMSS(TimeUtil.getDefaultSysDate())+".PDF" );
//			}
//
//			CenterFactory.setCenterInfoByTypeAndValue(CenterUtil.REGION_ID, regionID);
//
//			IEInvoiceSV sv = EInvoiceFactory.getIEInvoiceSV();
//
//			IBOAmEInvRecValue iBOAmEInvRecValue = sv.amEInvRecQry(invoiceID, regionID, billMonth);
//			if(iBOAmEInvRecValue == null){
//				throw new Exception("保存发票推送信息失败，根据发票记录id："+invoiceID+"、地市："+regionID+"、账期："+billMonth+"找不到发票记录信息");
//			}
//
//			log.debug("根据发票记录id："+invoiceID+"、地市："+regionID+"、账期："+billMonth+"查询发票记录的结果集iBOAmEInvRecValue："+iBOAmEInvRecValue);
//
//			if((iBOAmEInvRecValue.getRandomCode() == null || "".equals(iBOAmEInvRecValue.getRandomCode())
//					|| !iBOAmEInvRecValue.getRandomCode().equals(randomCode))
//					&& isLocal.longValue() != 0){//是否本地查询 0：是、否则不是（如网厅等）
//				throw new Exception("输入的随机码与发票记录表的不一致或者发票记录表的随机码为空，不能下载或预览");
//			}
//			String fileId = iBOAmEInvRecValue.getFileId();
//		    //找到file_id字段，到云平台管理系统下载文件
//			String urlPath = sv.getUrl(fileId);
//			url = new URL(urlPath);
//			//打开连接
//			httpConnection = (HttpURLConnection) url.openConnection();
//
//			bis = new BufferedInputStream(httpConnection.getInputStream());
//			bos = new BufferedOutputStream(response.getOutputStream());
//
//			byte[] buffer = new byte[1024*128];
//			int length = 0;
//
//			while((length = bis.read(buffer)) != -1){
//			    bos.write(buffer, 0, length);
//			}
//		} catch (Exception e) {
//			log.error("异常："+e.getMessage());
//		} finally {
//			 if (bis != null) bis.close();
//		     if (bos != null) bos.close();
//		     if (url != null) url = null;
//		     if (httpConnection != null) httpConnection = null;
//		}
	}
	
}
