package com.asiainfo.einvoice.web;

import com.ai.appframe2.web.action.BaseAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InvoiceFileManagementAction extends BaseAction {
	
	private static transient Log log = LogFactory.getLog(InvoiceFileManagementAction.class);
	
	/**
	 * ���ӷ�Ʊ���ء�Ԥ��
	 * by quanly
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void doGetInvoiceFiles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		Long invoiceID = Long.parseLong(HttpUtil.getAsString(request, "INVOICE_ID"));//��Ʊ��¼ID
//		String regionID = HttpUtil.getAsString(request, "REGION_ID");//����
//		Long billMonth = Long.parseLong(HttpUtil.getAsString(request, "BILL_MONTH"));//����
//		Long isDown = Long.parseLong(HttpUtil.getAsString(request, "IS_DOWN"));//�Ƿ����� 0�����ء�������Ԥ��
//		Long isLocal = Long.parseLong(HttpUtil.getAsString(request, "IS_LOCAL"));//�Ƿ񱾵ز�ѯ 0���ǡ������ǣ��������ȣ�
//		String randomCode = HttpUtil.getAsString(request, "RANDOM_CODE");//����루IS_LOCAL��Ϊ0ʱ����ֵ�ش���
//
//		if(invoiceID == null){
//			throw new Exception("����INVOICE_ID����Ϊ�գ��봫�뷢Ʊ��¼id");
//		}
//		if(regionID == null){
//			throw new Exception("����REGION_ID����Ϊ�գ��봫�����");
//		}
//		if(billMonth == null){
//			throw new Exception("����BILL_MONTH����Ϊ�գ��봫�뷢Ʊ����");
//		}
//		if(isDown == null){
//			throw new Exception("����IS_DOWN����Ϊ�գ���ѡ���Ƿ����أ����� 0���ء���������ֵ��Ԥ�������������֣�");
//		}
//		if(isLocal == null){
//			throw new Exception("����IS_LOCAL����Ϊ�գ���ѡ���Ƿ񱾵ز�ѯ 0���ǡ������ǣ����������֣�");
//		}
//		if(isLocal.longValue() != 0 && (randomCode == null || "".equals(randomCode))){
//			throw new Exception("����RANDOM_CODE����Ϊ�գ������������");
//		}
//
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
//		URL url = null;
//		HttpURLConnection httpConnection = null;
//		try {
//			// PDF �ļ��� MIME ����
//			response.setContentType( "application/pdf" );
//			//Ҳ����ͨ������ķ�ʽ������
//			response.setHeader("Content-type", "application/pdf");
//
//			// ����ģʽ
//			if(isDown == 0){//�Ƿ����� 0�����ء�������Ԥ��
//				response.setHeader("Content-disposition",  "attachment; filename=DZFP"+com.ai.common.util.TimeUtil.getYYYYMMDDHHMMSS(TimeUtil.getDefaultSysDate())+".PDF" );
//			}
//
//			CenterFactory.setCenterInfoByTypeAndValue(CenterUtil.REGION_ID, regionID);
//
//			IEInvoiceSV sv = EInvoiceFactory.getIEInvoiceSV();
//
//			IBOAmEInvRecValue iBOAmEInvRecValue = sv.amEInvRecQry(invoiceID, regionID, billMonth);
//			if(iBOAmEInvRecValue == null){
//				throw new Exception("���淢Ʊ������Ϣʧ�ܣ����ݷ�Ʊ��¼id��"+invoiceID+"�����У�"+regionID+"�����ڣ�"+billMonth+"�Ҳ�����Ʊ��¼��Ϣ");
//			}
//
//			log.debug("���ݷ�Ʊ��¼id��"+invoiceID+"�����У�"+regionID+"�����ڣ�"+billMonth+"��ѯ��Ʊ��¼�Ľ����iBOAmEInvRecValue��"+iBOAmEInvRecValue);
//
//			if((iBOAmEInvRecValue.getRandomCode() == null || "".equals(iBOAmEInvRecValue.getRandomCode())
//					|| !iBOAmEInvRecValue.getRandomCode().equals(randomCode))
//					&& isLocal.longValue() != 0){//�Ƿ񱾵ز�ѯ 0���ǡ������ǣ��������ȣ�
//				throw new Exception("�����������뷢Ʊ��¼��Ĳ�һ�»��߷�Ʊ��¼��������Ϊ�գ��������ػ�Ԥ��");
//			}
//			String fileId = iBOAmEInvRecValue.getFileId();
//		    //�ҵ�file_id�ֶΣ�����ƽ̨����ϵͳ�����ļ�
//			String urlPath = sv.getUrl(fileId);
//			url = new URL(urlPath);
//			//������
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
//			log.error("�쳣��"+e.getMessage());
//		} finally {
//			 if (bis != null) bis.close();
//		     if (bos != null) bos.close();
//		     if (url != null) url = null;
//		     if (httpConnection != null) httpConnection = null;
//		}
	}
	
}
