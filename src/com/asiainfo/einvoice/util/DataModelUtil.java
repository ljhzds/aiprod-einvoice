package com.asiainfo.einvoice.util;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.*;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by huangjh on 16/3/31.
 */
public class DataModelUtil {
    /**
     * 转换bean为DC
     *
     * @param bean
     * @param dci
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T extends DataContainer> T convertBean2Dc(Object bean, Class<T> dci) throws Exception {
        T data = null;
        if (bean != null) {
            //实例化DC
            data = dci.newInstance();
            insertBean2Dc(bean, data);
        }
        return data;

    }

    /**
     * 将bean加入DC
     *
     * @param bean
     * @param dci
     * @param <T>
     * @throws Exception
     */
    public static <T extends DataContainer> void insertBean2Dc(Object bean, T dci) throws Exception {
        if (bean != null) {
            //实例化DC
            Field[] fs = bean.getClass().getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                Object val = f.get(bean);
                String name = transferParamName(f.getName());
                ObjectType type = dci.getType();
                if (type.hasProperty(name)) {
                    String javaType = type.getProperty(name).getJavaDataType();
                    dci.set(name, DataType.transfer(val, javaType));
                }
            }
        }
    }

    /**
     * DC转化
     *
     * @param source
     * @param t
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T extends DataContainer> T convertDc(DataContainer source, Class<T> t) throws Exception {
        T data = null;
        if (source != null && t != null) {
            data = t.newInstance();
            mixDc(data, source);
        }
        return data;
    }

    /**
     * 混合DC
     *
     * @param target 目标DC
     * @param source 源DC
     * @throws Exception
     */
    public static <T extends DataContainer> void mixDc(T target, DataContainer... source) throws Exception {
        if (target != null && !ArrayUtils.isEmpty(source)) {
            for (DataContainer dci : source) {
                Map props = dci.getProperties();
                Iterator<Map.Entry<String, Object>> itr = props.entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry<String, Object> entry = itr.next();
                    String key = entry.getKey();
                    ObjectType type = target.getType();
                    if (type.hasProperty(key)) {
                        String javaType = type.getProperty(key).getJavaDataType();
                        target.set(key, DataType.transfer(entry.getValue(), javaType));
                    }

                }
            }

        }
    }

    /**
     * 混合DC
     *
     * @param target
     * @param source
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T extends DataContainer> T mixDc(Class<T> target, DataContainer... source) throws Exception {
        T t = target.newInstance();
        mixDc(t, source);
        return t;
    }

    /**
     * 将bean混入DC
     *
     * @param cls
     * @param beans
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T extends DataContainer> T mixBean2Dc(Class<T> cls, Object... beans) throws Exception {
        T data = null;
        if (beans != null) {
            data = cls.newInstance();
            for (int i = 0; i < beans.length; i++) {
                //实例化DC
                insertBean2Dc(beans[i], data);
            }
            return data;
        }
        return data;
    }

    /**
     * 将bean混入DC
     *
     * @param dc
     * @param beans
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T extends DataContainer> void mixBean2Dc(T dc, Object... beans) throws Exception {
        if (beans != null) {
            for (int i = 0; i < beans.length; i++) {
                //实例化DC
                insertBean2Dc(beans[i], dc);
            }
        }
    }

    /**
     * 长字段分割处理
     *
     * @param t
     * @param param
     * @param data
     * @param <T>
     * @throws Exception
     */
    public static <T extends DataContainer> void dealLargeParam(T t, String param, String data) throws Exception {
        param = param.toUpperCase();
        if (StringUtils.isNotBlank(data)) {
            int length = data.length();
            if (length > 1000) {
                //计算字符串分为几分
                double count = Math.ceil(length / 1000.0);
                for (int i = 0; i < count; i++) {
                    int end = data.length() > 1000 ? 1000 : data.length();
                    String str = data.substring(0, end);
                    if (t.getType().hasProperty(param + (i + 1))) {
                        t.set(param + (i + 1), str);
                    }
                    data = data.substring(end);
                }
            } else if (t.getType().hasProperty(param + 1)) {
                t.set(param + 1, data);
            }
        }

    }

    public static Map convertBean2Map(Object o) throws Exception {
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        Map m = new HashMap();
        for (Field field : fields) {
            field.setAccessible(true);
            m.put(transferParamName(field.getName()), field.get(o));
        }
        return m;
    }

    //
    public static String transferParamName(String param) {
        char[] cs = param.toCharArray();

        int length = cs.length;

        for (int i = length - 1; i >= 0; i--) {
            if (Character.isUpperCase(cs[i]) && i > 0) {
                param = param.substring(0, i) + "_" + param.substring(i, param.length());
            }
        }

        return param.toUpperCase();
    }

    /**
     * 将map转化为DC
     *
     * @param cls
     * @param m
     * @param <T>
     * @return
     */
    public static <T extends DataContainer> T convertMap2Dc(Class<T> cls, Map m) throws IllegalAccessException, InstantiationException, AIException {
        T t = null;
        if (m != null && cls != null) {
            t = cls.newInstance();
            Iterator<Map.Entry> itr = m.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<String, ?> entry = itr.next();
                String key = entry.getKey().toUpperCase();
                if (t.hasProperty(key)) {
                    String javaCls = t.getType().getProperty(key).getJavaDataType();
                    Object value = DataType.transfer(entry.getValue(), javaCls);
                    t.set(key, value);
                }
            }
        }
        return t;
    }

    /**
     * 独立事务代理，如果使用独立事务，比如日志等，请使用该方法
     *
     * @throws Exception
     */
    public static void dependTransaction(ExecuteEvent event) throws Exception {
        ServiceManager.getSession().suspend();
        try {
            ServiceManager.getSession().startTransaction();
            event.execute();
            ServiceManager.getSession().commitTransaction();
        } catch (Exception e) {
            ServiceManager.getSession().rollbackTransaction();
        } finally {
            ServiceManager.getSession().resume();
        }
    }
}
