package com.asiainfo.einvoice.commons.template;

import com.asiainfo.einvoice.commons.template.impl.SqlTemplateEngine;
import com.asiainfo.einvoice.commons.template.impl.XmlTemplateEngine;
import com.asiainfo.einvoice.commons.template.interfaces.AbstractTemplateEngine;
import com.asiainfo.einvoice.util.EInvoiceConfig;
import org.apache.commons.lang.StringUtils;

/**
 * Created by huangjh on 16/4/1.
 */
public class EInvoiceTemplateProvider {
    private static <T extends AbstractTemplateEngine> T loadTemplate(Class<T> engine) throws Exception {
        return engine.newInstance();
    }

    private static XmlTemplateEngine getXmlTemplateEngine(String configItem, String detaultPath) throws Exception {
        XmlTemplateEngine engine = loadTemplate(XmlTemplateEngine.class);

        String config = EInvoiceConfig.get(configItem);
        if (StringUtils.isNotBlank(config)) {
            engine.setTemplateUrl(config);
        } else {
            engine.setTemplateUrl(detaultPath);
        }

        return engine;
    }

    public static XmlTemplateEngine getSkIssuingReqXmlEngine() throws Exception {
        return getXmlTemplateEngine("template.xml.sk_issuing_req", "com/asiainfo/einvoice/commons/template/vm/sk_issuing_req_xml.vm");
    }
    public static XmlTemplateEngine getSkIssuingContentXmlEngine() throws Exception {
        return getXmlTemplateEngine("template.xml.sk_issuing_content", "com/asiainfo/einvoice/commons/template/vm/sk_issuing_content_xml.vm");
    }


    public static XmlTemplateEngine getSkRedReqXmlEngine() throws Exception {
        return getXmlTemplateEngine("template.xml.sk_red_req", "com/asiainfo/einvoice/commons/template/vm/sk_red_req_xml.vm");
    }

    public static XmlTemplateEngine getSkQueryReqXmlEngine() throws Exception {
        return getXmlTemplateEngine("template.xml.sk_query_req", "com/asiainfo/einvoice/commons/template/vm/sk_query_req_xml.vm");
    }

    public static XmlTemplateEngine getEmail139MsgEngine() throws Exception {
        return getXmlTemplateEngine("template.msg.email_139_pusher", "com/asiainfo/einvoice/commons/template/vm/email_139_pusher_msg.vm");
    }

    public static SqlTemplateEngine getSqlTemplateEngine() throws Exception {
        SqlTemplateEngine engine = loadTemplate(SqlTemplateEngine.class);
        return engine;
    }

    public static XmlTemplateEngine getSmsMsgEngine() throws Exception {
        return getXmlTemplateEngine("template.msg.sms_pusher", "com/asiainfo/einvoice/commons/template/vm/sms_pusher_msg.vm");
    }
}
