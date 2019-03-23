package com.asiainfo.einvoice.commons.template.impl;

import com.asiainfo.einvoice.commons.template.interfaces.AbstractTemplateEngine;
import org.apache.commons.lang.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangjh on 16/3/31.
 */
public class SqlTemplateEngine extends AbstractTemplateEngine {
    private Map<String, Object> sp = new HashMap();

    public void addParams(String param, String op, String value) throws Exception {
        SqlParam sql = new SqlParam(param, op, value);
        Object[] objs = (Object[]) this.sp.get("params");
        this.sp.put("params", objs == null ? new SqlParam[]{sql} : ArrayUtils.add(objs, sql));
    }

    public void setParams(SqlParam[] params) throws Exception {
        this.sp.put("params", params);
    }

    public void setTableName(String name) throws Exception {
        this.sp.put("table", name);
    }

    @Override
    public Map getParams() throws Exception {
        return this.sp;
    }

    @Override
    public String getTemplateUrl() throws Exception {
        return "com/asiainfo/einvoice/commons/template/vm/sql.vm";
    }

    public class SqlParam {
        private String param;
        private String op;
        private String value;

        public SqlParam(String param, String op, String value) {
            this.param = param;
            this.op = op;
            this.value = value;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getOp() {
            return op;
        }

        public void setOp(String op) {
            this.op = op;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
//        InputStream ins = SqlTemplateEngine.class.getResourceAsStream("vm/sql.vm");
//        StringWriter writer = new StringWriter();
//        int i=0;
//        while((i = ins.read())!=-1){
//            writer.write(i);
//        }
//        System.out.println(writer.toString());

        SqlTemplateEngine engine = new SqlTemplateEngine();
        engine.addParams("test", "BETWEEN", null);
        engine.setTableName("TEST");
        String str = engine.render();
        System.out.println(str);
    }

}
