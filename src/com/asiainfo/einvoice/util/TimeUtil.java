package com.asiainfo.einvoice.util;

import java.sql.Timestamp;
import java.text.ParseException;

/**
 * Created by huangjh on 16/3/23.
 */
public class TimeUtil {
    public static Timestamp getDefaultSysDate() throws Exception {
        return com.ai.common.util.TimeUtil.getPrimaryDataSourceSysDate();
    }


    /**
     * 将日期字符串转换为日期
     *
     * @param strDate
     * @param mask
     * @return
     * @throws ParseException
     */
    public static Timestamp convertStringToDate(String strDate, String mask) throws Exception {
        return com.ai.common.util.TimeUtil.getTimstampByString(strDate, mask);
    }
}
