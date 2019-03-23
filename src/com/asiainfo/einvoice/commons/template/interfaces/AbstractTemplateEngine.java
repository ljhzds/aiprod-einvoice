package com.asiainfo.einvoice.commons.template.interfaces;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Map;

/**
 * Created by huangjh on 16/3/31.
 */
public abstract class AbstractTemplateEngine {
    public abstract Map getParams() throws Exception;

    public abstract String getTemplateUrl() throws Exception;

    /**
     * ��Ⱦģ��
     *
     * @throws Exception
     */
    public String render() throws Exception {
        VelocityEngine ve = new VelocityEngine();
        //������Դ·��
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        //��ʼ��
        ve.init();
        //��ȡģ��
        Template template = ve.getTemplate(getTemplateUrl());
        //��Ⱦģ��
        StringWriter sw = new StringWriter();
        template.merge(new VelocityContext(getParams()), sw);
        sw.flush();

        String xml = sw.toString();
        xml = xml.replaceAll("(\\n|\\t)", "");
        return xml;
    }
}
