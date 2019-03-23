package com.asiainfo.einvoice.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.InputStream;

/**
 * Created by huangjh on 16/4/19.
 */
public class XmlUtil {
    /**
     * @param xml
     * @param t
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T fromXml(String xml, Class<T> t) throws Exception {
        XStream xs = new XStream(new StaxDriver());
        xs.processAnnotations(t);
        return (T) xs.fromXML(xml);
    }

    /**
     *
     * @param ins
     * @param t
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T fromXml(InputStream ins, Class<T> t) throws Exception {
        XStream xs = new XStream(new StaxDriver());
        xs.processAnnotations(t);
        return (T) xs.fromXML(ins);
    }
}
