package com.asiainfo.einvoice.customized.message.pusher.impl;

import com.ai.appframe2.web.json.JsonUtil;
import com.ai.comframe.utils.TimeUtil;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.ArrayUtils;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.einvoice.EInvoiceConst;
import com.asiainfo.einvoice.core.EInvoiceFactory;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstBean;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstValue;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePushTaskValue;
import com.asiainfo.einvoice.customized.message.pusher.interfaces.IEInvoiceMessagePusher;
import com.asiainfo.einvoice.inter.email139.ws.EInv139WebServiceClient;
import com.asiainfo.einvoice.util.EInvoiceUtil;
import com.asiainfo.einvoice.util.MD5Util;
import com.asiainfo.einvoice.util.TripleDESUtil;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EInvoiceMessageEmailPusher implements IEInvoiceMessagePusher {
    private static Logger logger = Logger.getLogger(EInvoiceMessageEmailPusher.class);

    @Override
    public void push(IBOInvoicePushTaskValue t) throws Exception {
        // ƴ�ӵ����ʼ�����
        String msg = parse(t);
        logger.debug("���Json����" + msg);
        String secretKey = EInvoiceUtil.getElecInvoiceStatic("password"); //��Կ
        if (StringUtils.isNotBlank(secretKey)) {
            //DES�ԳƼ����㷨
            String content = TripleDESUtil.encryptBasedDes(msg, secretKey);
            logger.debug("����139�ӿ�ǰ���Ƚ����DES�ԳƼ��ܣ�" + content);
//			String returnResult = EInv139WebServiceClient.getInstance().invoiceMailSend(content);//����139����
            String returnResult = sendEmail(content);//����139����
            logger.debug("����139�ӿں󣬷��ر��ģ�" + returnResult);
            if (returnResult != null && !"".equals(returnResult)) {
                Map map = JsonUtil.getMapFromJsObject(returnResult);
                if (map.get("returnCode") != null) {
                    String code = map.get("returnCode").toString();
                    if (code.equals("0001")) {//0000��ʾ�ɹ���0001��ʾʧ��
                        if (map.get("returnMessage") != null) {
                            throw new Exception(map.get("returnMessage").toString());
                        } else {
                            throw new Exception("�����ʼ��ӿ������ʼ�ʧ��");
                        }
                    }
                }
            }

        }

    }

    private String sendEmail(String msg) throws Exception {// �����ʼ�
        EInv139WebServiceClient client = EInv139WebServiceClient.getInstance();
        return client.eInvWS(msg);
    }

    private String parse(IBOInvoicePushTaskValue t) throws Exception {
        String[] regionAndCycle = t.getSharding().split("_");
        String region = regionAndCycle[0];
        String cycle = regionAndCycle[1];


        String custType = "6";

        BOInvoiceDsDtlBean[] dtls = EInvoiceFactory.getIEInvoiceSV().queryEInvoiceDsDtlByDsId(t.getInvoiceDsId(), region, cycle);
        IBOInvoiceInstValue inst = EInvoiceFactory.getIEInvoiceSV().queryEInvoiceInst(t.getInvoiceInstanceId(), region, cycle);
        //��Ʊ��ϸƷĿ
        StringBuffer itemNames = new StringBuffer();
        if (!ArrayUtils.isEmpty(dtls)) {
            for (BOInvoiceDsDtlBean dtl : dtls) {
                itemNames.append(dtl.getItemName()).append(";");
            }
        }
        String sItemNames = itemNames.substring(0, itemNames.length() - 1);

        //3.Զ�̶�ȡ�ļ��������ļ���TimeUtil.getDefaultSysDate()
        InputStream inputStream = EInvoiceFactory.getIEInvoiceSV().downloadEInvoiceInst(t.getInvoiceInstanceId(), regionAndCycle[0], regionAndCycle[1]);
        String base64 = EInvoiceUtil.getbase64Code(inputStream);

        //json������
        Map contentMap = new HashMap();
        Map KHXXMap = new HashMap();
        Map FPXXMap = new HashMap();
//		KHXXMap.put("KHSJHM", billId); //�ֻ�����
//		KHXXMap.put("KHBS", custId); //�ͻ���ʶ
//		KHXXMap.put("KHMC", custName); //�ͻ�����
        KHXXMap.put("KHLX", custType); //�ͻ����ͣ�1��ʾ�����û���2��ʾ��ҵ�û���3��ʾ��ͥ����û���4��ʾ�������û���5��ʾ�����û���6�����ն˵�ҵ���û�������ͻ�����ҵ��ʱ����Ҫ�ṩ�ͻ����ơ��ֻ��������Ϣ
        KHXXMap.put("KHYXDZ", t.getPushTarget()); //�ͻ������ַ
        KHXXMap.put("KHGSD", regionAndCycle[0]); //�ͻ������أ�����
//        KHXXMap.put("KHFQQD", t.); //�ͻ������������ͻ������ʼ����������������1��ʾ����Ӫҵ����2��ʾ����Ӫҵ����3��ʾ10086���ߣ�4��ʾ10085��5��ʾ����Ӫҵ����6��ʾWAPӪҵ����7��ʾ�ֻ�Ӫҵ��     ��APP����8��ʾ�ƶ��̳ǣ�9��ʾ�����̳ǣ�10��ʾ��פ�������̣���è�콢�꣩��11��ʾ��������

        Timestamp timestamp = inst.getCreateTime() == null ? TimeUtil.getSysTime() : inst.getCreateTime();
        Date kpDate = new Date(timestamp.getTime());
        FPXXMap.put("KPSJ", EInvoiceUtil.getTime(kpDate));//��Ʊʱ�䣬Unixʱ���   0���롢�������
//        FPXXMap.put("KPQD", inst.getChannelId()); //��Ʊ������1��ʾ����Ӫҵ����2��ʾ����Ӫҵ����3��ʾ10086���ߣ�4��ʾ10085��5��ʾ����Ӫҵ����6��ʾWAPӪҵ����7��ʾ�ֻ�Ӫҵ��     ��APP����8��ʾ�ƶ��̳ǣ�9��ʾ
        FPXXMap.put("FPJE", inst.getInvoiceAmount()); //��Ʊ���
        FPXXMap.put("FPMXPM", sItemNames); //��Ʊ��ϸƷĿ
        FPXXMap.put("FPPDFWJ", base64); //��Ʊ
        FPXXMap.put("FPJYM", MD5Util.md5UpperCase32(base64, "UTF-8")); //MD5У����
        FPXXMap.put("SFBS", EInvoiceConst.E_INV_PROVINCE_CODE_ZHEJIANG); //ʡ�ݱ�ʶ
//		FPXXMap.put("YWLSH", "DZFP_"+ElecInvoiceConst.E_INV_PROVINCE_CODE_ZHEJIANG+"_"+billId+"_"+
//						custId+"_"+custName+"_"+System.currentTimeMillis());//ҵ����ˮ�ţ������淶��ҵ�����ͣ�DZFP��_ʡ�ݱ�ʶ_�ͻ��ֻ�����_�ͻ���ʶ_�ͻ�����_ʱ��������룩��
        FPXXMap.put("YWLSH", "DZFP_" + EInvoiceConst.E_INV_PROVINCE_CODE_ZHEJIANG + "_" + System.currentTimeMillis());//ҵ����ˮ�ţ������淶��ҵ�����ͣ�DZFP��_ʡ�ݱ�ʶ_ʱ��������룩��
        contentMap.put("DZFPYJTS_KHXX", KHXXMap);
        contentMap.put("DZFPYJTS_FPXX", FPXXMap);

        return JsonUtil.getJsonFromMap(contentMap);
    }

}
