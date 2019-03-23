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
        //10位随机数
        Long longRandom = EInvoiceUtil.getRandom(1000000000L, 9999999999L);
        //编码格式
        String encoding = "".equals(EInvoiceUtil.getElecInvoiceStatic("encoding")) ? "utf-8" : EInvoiceUtil.getElecInvoiceStatic("encoding");
        //秘钥
        String secretKey = EInvoiceUtil.base64Encode(MD5Util.md5UpperCase(longRandom + EInvoiceUtil.getElecInvoiceStatic("interface.globalInfo.passWord"), encoding), encoding); //3DES密钥
        //获取内容
        String content = getContent(dsBean, encoding, dsItemBeans);
        //获取数据描述信息
        DataDescription dd = getDataDescription(content);
        //3DES加密
        byte[] contentBytes = TripleDESUtil.encryptMode(secretKey.getBytes(encoding), content.getBytes(encoding));
        //如果需要压缩，则进行压缩处理
        if ("1".equals(dd.getZipCode())) {
            contentBytes = EInvoiceUtil.compress(contentBytes);
        }
        //BASE64编码
        content = new String(EInvoiceUtil.base64EncodeBytes(contentBytes), encoding); //base64加密

        //设置请求
        XmlTemplateEngine reqEngine = EInvoiceTemplateProvider.getSkIssuingReqXmlEngine();
        //添加全局数据
        reqEngine.setParams(getGlobalInfo(dsBean, longRandom, secretKey));
        //添加加密描述
        reqEngine.setParams(dd);
        //添加请求内容
        reqEngine.push("CONTENT", content);
        //渲染
        return reqEngine.render();
    }

    private DataDescription getDataDescription(String content) {
        DataDescription dd = new DataDescription();
        //设置是否需要加密
        dd.setEncryptCode("1");
        //设置加密方式
        dd.setCodeType("3DES");
        //获取压缩阈值
        String sIsZip = EInvoiceUtil.getElecInvoiceStatic("iszip");
        //默认10K
        int iIsZip = "".equals(sIsZip) ? 10 : Integer.parseInt(sIsZip);
        //设置阈值，如果超过，则压缩标志为1
        dd.setZipCode(content.getBytes().length <= iIsZip * 1024 ? "0" : "1");
        return dd;
    }

    private String getContent(BOInvoiceDsBean dsBean, String encoding, BOInvoiceDsDtlBean[] dsItemBeans) throws Exception {//发票订单流水号
        String FPQQLSH = EInvoiceUtil.getRandom(100000, 999999) + com.ai.common.util.TimeUtil.getYYYYMMDDHHMMSS(new Date());
        dsBean.setSoOrderSeria(FPQQLSH);
        //加载XML模板引擎
        XmlTemplateEngine engine = EInvoiceTemplateProvider.getSkIssuingContentXmlEngine();
        //添加业务数据
        engine.setParams(dsBean);
        engine.setParams(dsItemBeans);
        //添加平台编码
        engine.push("DSPTBM", EInvoiceUtil.getElecInvoiceStatic("content.REQUEST_FPKJXX.FPKJXX_FPTXX.DSPTBM"));

        //渲染Content内容
        String xml = engine.render();
        //格式化输出
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
        //加载XML模板引擎
        XmlTemplateEngine engine = EInvoiceTemplateProvider.getSkRedReqXmlEngine();
        //添加业务数据
        engine.setParams(inst);
        //渲染
        return engine.render();
    }

    @Override
    public String buildSkQueryMsg(BOInvoiceInstBean inst) throws Exception {
        //加载XML模板引擎
        XmlTemplateEngine engine = EInvoiceTemplateProvider.getSkQueryReqXmlEngine();
        //添加业务数据
        engine.setParams(inst);
        //渲染
        return engine.render();
    }
}
