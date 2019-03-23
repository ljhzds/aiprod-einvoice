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
        // 拼接电子邮件内容
        String msg = parse(t);
        logger.debug("入参Json串：" + msg);
        String secretKey = EInvoiceUtil.getElecInvoiceStatic("password"); //密钥
        if (StringUtils.isNotBlank(secretKey)) {
            //DES对称加密算法
            String content = TripleDESUtil.encryptBasedDes(msg, secretKey);
            logger.debug("调用139接口前，先将入参DES对称加密：" + content);
//			String returnResult = EInv139WebServiceClient.getInstance().invoiceMailSend(content);//推送139短信
            String returnResult = sendEmail(content);//推送139短信
            logger.debug("调用139接口后，返回报文：" + returnResult);
            if (returnResult != null && !"".equals(returnResult)) {
                Map map = JsonUtil.getMapFromJsObject(returnResult);
                if (map.get("returnCode") != null) {
                    String code = map.get("returnCode").toString();
                    if (code.equals("0001")) {//0000表示成功，0001表示失败
                        if (map.get("returnMessage") != null) {
                            throw new Exception(map.get("returnMessage").toString());
                        } else {
                            throw new Exception("调用邮件接口推送邮件失败");
                        }
                    }
                }
            }

        }

    }

    private String sendEmail(String msg) throws Exception {// 发送邮件
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
        //发票明细品目
        StringBuffer itemNames = new StringBuffer();
        if (!ArrayUtils.isEmpty(dtls)) {
            for (BOInvoiceDsDtlBean dtl : dtls) {
                itemNames.append(dtl.getItemName()).append(";");
            }
        }
        String sItemNames = itemNames.substring(0, itemNames.length() - 1);

        //3.远程读取文件，返回文件流TimeUtil.getDefaultSysDate()
        InputStream inputStream = EInvoiceFactory.getIEInvoiceSV().downloadEInvoiceInst(t.getInvoiceInstanceId(), regionAndCycle[0], regionAndCycle[1]);
        String base64 = EInvoiceUtil.getbase64Code(inputStream);

        //json请求报文
        Map contentMap = new HashMap();
        Map KHXXMap = new HashMap();
        Map FPXXMap = new HashMap();
//		KHXXMap.put("KHSJHM", billId); //手机号码
//		KHXXMap.put("KHBS", custId); //客户标识
//		KHXXMap.put("KHMC", custName); //客户名称
        KHXXMap.put("KHLX", custType); //客户类型，1表示个人用户；2表示企业用户；3表示家庭宽带用户；4表示互联网用户；5表示其他用户；6购买终端等业务用户，这类客户办理业务时不需要提供客户名称、手机号码等信息
        KHXXMap.put("KHYXDZ", t.getPushTarget()); //客户邮箱地址
        KHXXMap.put("KHGSD", regionAndCycle[0]); //客户归属地，地市
//        KHXXMap.put("KHFQQD", t.); //客户发起渠道，客户发起邮件推送请求的渠道：1表示自有营业厅；2表示加盟营业厅；3表示10086热线；4表示10085；5表示网上营业厅；6表示WAP营业厅；7表示手机营业厅     （APP）；8表示移动商城；9表示积分商城；10表示进驻电商商铺（天猫旗舰店）；11表示其他渠道

        Timestamp timestamp = inst.getCreateTime() == null ? TimeUtil.getSysTime() : inst.getCreateTime();
        Date kpDate = new Date(timestamp.getTime());
        FPXXMap.put("KPSJ", EInvoiceUtil.getTime(kpDate));//开票时间，Unix时间戳   0：秒、否则毫秒
//        FPXXMap.put("KPQD", inst.getChannelId()); //开票渠道，1表示自有营业厅；2表示加盟营业厅；3表示10086热线；4表示10085；5表示网上营业厅；6表示WAP营业厅；7表示手机营业厅     （APP）；8表示移动商城；9表示
        FPXXMap.put("FPJE", inst.getInvoiceAmount()); //发票金额
        FPXXMap.put("FPMXPM", sItemNames); //发票明细品目
        FPXXMap.put("FPPDFWJ", base64); //发票
        FPXXMap.put("FPJYM", MD5Util.md5UpperCase32(base64, "UTF-8")); //MD5校验码
        FPXXMap.put("SFBS", EInvoiceConst.E_INV_PROVINCE_CODE_ZHEJIANG); //省份标识
//		FPXXMap.put("YWLSH", "DZFP_"+ElecInvoiceConst.E_INV_PROVINCE_CODE_ZHEJIANG+"_"+billId+"_"+
//						custId+"_"+custName+"_"+System.currentTimeMillis());//业务流水号，命名规范“业务类型（DZFP）_省份标识_客户手机号码_客户标识_客户名称_时间戳（毫秒）”
        FPXXMap.put("YWLSH", "DZFP_" + EInvoiceConst.E_INV_PROVINCE_CODE_ZHEJIANG + "_" + System.currentTimeMillis());//业务流水号，命名规范“业务类型（DZFP）_省份标识_时间戳（毫秒）”
        contentMap.put("DZFPYJTS_KHXX", KHXXMap);
        contentMap.put("DZFPYJTS_FPXX", FPXXMap);

        return JsonUtil.getJsonFromMap(contentMap);
    }

}
