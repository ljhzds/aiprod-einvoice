package com.asiainfo.einvoice.customized.message.builder.impl;

import java.util.Date;

import org.dom4j.Document;

import com.asiainfo.einvoice.commons.template.EInvoiceTemplateProvider;
import com.asiainfo.einvoice.commons.template.impl.XmlTemplateEngine;
import com.asiainfo.einvoice.core.def.DataDescription;
import com.asiainfo.einvoice.core.def.GlobalInfo;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstBean;
import com.asiainfo.einvoice.customized.message.builder.interfaces.IEInvoiceSkMessageBuilder;
import com.asiainfo.einvoice.util.EInvoiceUtil;
import com.asiainfo.einvoice.util.MD5Util;
import com.asiainfo.einvoice.util.TripleDESUtil;

public class DefaultEInvoiceSkMessageBuilder implements IEInvoiceSkMessageBuilder {


    @Override
    public String buildSkIssuingMsg(BOInvoiceDsBean dsBean, BOInvoiceDsDtlBean... dsItemBeans) throws Exception {
        //10λ�����
        Long longRandom = EInvoiceUtil.getRandom(1000000000L, 9999999999L);
        //�����ʽ
        String encoding = "".equals(EInvoiceUtil.getElecInvoiceStatic("encoding")) ? "utf-8" : EInvoiceUtil.getElecInvoiceStatic("encoding");
        //��Կ
        String secretKey = EInvoiceUtil.base64Encode(MD5Util.md5UpperCase(longRandom + EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.passWord"), encoding), encoding); //3DES��Կ
        //��ȡ����
        String content = getContent(dsBean, encoding, dsItemBeans);
        //��ȡ����������Ϣ
        DataDescription dd = getDataDescription(content);
        //3DES����
        byte[] contentBytes = TripleDESUtil.encryptMode(secretKey.getBytes(encoding), content.getBytes(encoding));
        //�����Ҫѹ���������ѹ������
        if ("1".equals(dd.getZipCode())) {
            contentBytes = EInvoiceUtil.compress(contentBytes);
        }
        //BASE64����
        content = new String(EInvoiceUtil.base64EncodeBytes(contentBytes), encoding); //base64����

        //��������
        XmlTemplateEngine reqEngine = EInvoiceTemplateProvider.getSkIssuingReqXmlEngine();
        //���ȫ������
        reqEngine.setParams(getGlobalInfo(dsBean, longRandom, secretKey));
        //��Ӽ�������
        reqEngine.setParams(dd);
        //�����������
        reqEngine.push("CONTENT", content);
        //��Ⱦ
        return reqEngine.render();
    }

    private DataDescription getDataDescription(String content) {
        DataDescription dd = new DataDescription();
        //�����Ƿ���Ҫ����
        dd.setEncryptCode("1");
        //���ü��ܷ�ʽ
        dd.setCodeType("3DES");
        //��ȡѹ����ֵ
        String sIsZip = EInvoiceUtil.getElecInvoiceStatic("iszip");
        //Ĭ��10K
        int iIsZip = "".equals(sIsZip) ? 10 : Integer.parseInt(sIsZip);
        //������ֵ�������������ѹ����־Ϊ1
        dd.setZipCode(content.getBytes().length <= iIsZip * 1024 ? "0" : "1");
        return dd;
    }

    private String getContent(BOInvoiceDsBean dsBean, String encoding, BOInvoiceDsDtlBean[] dsItemBeans) throws Exception {//��Ʊ������ˮ��
        String FPQQLSH = EInvoiceUtil.getRandom(100000, 999999) + com.ai.common.util.TimeUtil.getYYYYMMDDHHMMSS(new Date());
        dsBean.setSoOrderSeria(FPQQLSH);
        //����XMLģ������
        XmlTemplateEngine engine = EInvoiceTemplateProvider.getSkIssuingContentXmlEngine();
        //���ҵ������
        engine.setParams(dsBean);
        engine.setParams(dsItemBeans);
        //���ƽ̨����
        engine.push("DSPTBM", EInvoiceUtil.getElecInvoiceStatic("content.REQUEST_FPKJXX.FPKJXX_FPTXX.DSPTBM"));

        //��ȾContent����
        String xml = engine.render();
        //��ʽ�����
        Document doc = EInvoiceUtil.getXML(xml);
        return EInvoiceUtil.doc2String(doc, encoding);
    }

    private GlobalInfo getGlobalInfo(BOInvoiceDsBean dsBean, long longRandom, String secretKey) throws Exception {
        GlobalInfo info = new GlobalInfo();
        info.setAppId(EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.appId"));
        info.setTerminalCode(EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.terminalCode"));
        info.setInterfaceCode(EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.interfaceCode"));
        info.setVersion(EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.version"));
        info.setUserName(EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.userName"));

        String passWord = longRandom + secretKey;
        String requestTime = EInvoiceUtil.getNowDate("yyyy-MM-dd HH:mm:ss");

        info.setPassWord(passWord);
        info.setTaxpayerId(dsBean.getXhfNsrsbh());
        info.setAuthorizationCode(EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.userName"));
        info.setRequestCode(EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.requestCode"));
        info.setRequestTime(requestTime);
        info.setDataExchangeId(EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.requestCode") +
                EInvoiceUtil.getNowDate("yyyyMMdd") +
                dsBean.getSoOrderSeria());
        return info;
    }

    @Override
    public String buildSkRedMsg(BOInvoiceInstBean inst) throws Exception {
        //����XMLģ������
        XmlTemplateEngine engine = EInvoiceTemplateProvider.getSkRedReqXmlEngine();
        //���ҵ������
        engine.setParams(inst);
        //��Ⱦ
        return engine.render();
    }

    @Override
    public String buildSkQueryMsg(BOInvoiceInstBean inst) throws Exception {
        //����XMLģ������
        XmlTemplateEngine engine = EInvoiceTemplateProvider.getSkQueryReqXmlEngine();
        //���ҵ������
        engine.setParams(inst);
        //��Ⱦ
        return engine.render();
    }
}
