package com.asiainfo.einvoice.commons.template.impl;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.bo.boinfo.BONode;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ObjectType;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.ArrayUtils;
import com.asiainfo.einvoice.commons.template.interfaces.AbstractTemplateEngine;
import com.asiainfo.einvoice.core.def.bo.bean.BOBusiFeatureRelDefBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.util.DataModelUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangjh on 16/4/1.
 */
public class XmlTemplateEngine extends AbstractTemplateEngine {
    private Map props = new HashMap();
    private String path = "";

    public <T extends DataContainer> void setParams(T... t) throws Exception {
        if (!ArrayUtils.isEmpty(t)) {
            for (DataContainer ds : t) {
                //获取表名
                String table = ds.getObjectType().getMapingEnty();
                table = table.replaceAll("\\{|\\}", "");
                //获取BO下所有参数
                ObjectType objectType = ds.getType();
                String[] params = ((BONode) objectType).getAttrNameArray();
                //规范值
                Map map = new HashMap();
                Map props = ds.getProperties();
                if (!ArrayUtils.isEmpty(params)) {
                    for (String param : params) {
                        if (props.containsKey(param)) {
                            map.put(param, props.get(param));
                        } else {
                            map.put(param, "");
                        }
                    }
                }
                push(table, map);
            }
        }
    }

    public void push(String key, Object value) throws Exception {
        if (this.props.containsKey(key)) {
            Object sdi = this.props.get(key);
            if (sdi == null) {
                this.props.put(key, value);
            } else if (sdi.getClass().isArray()) {
                this.props.put(key, ArrayUtils.add((Object[]) sdi, value));
            } else {
                this.props.put(key, ArrayUtils.add(new Object[]{sdi}, value));
            }
        } else {
            this.props.put(key, value);
        }
    }

    public void setParams(Object... os) throws Exception {
        if (!ArrayUtils.isEmpty(os)) {
            for (Object o : os) {
                push(DataModelUtil.transferParamName(o.getClass().getSimpleName()), DataModelUtil.convertBean2Map(o));
            }
        }
    }


    @Override
    public Map getParams() throws Exception {
        return this.props;
    }

    public void setTemplateUrl(String path) throws Exception {
        this.path = path;
    }

    @Override
    public String getTemplateUrl() throws Exception {
        return this.path;
    }

    public static void main(String[] args) throws Exception {
        XmlTemplateEngine xml = new XmlTemplateEngine();
        xml.setParams(new BOBusiFeatureRelDefBean(), new BOInvoiceDsBean());
    }
}
