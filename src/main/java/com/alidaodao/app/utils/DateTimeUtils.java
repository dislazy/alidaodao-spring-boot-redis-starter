package com.alidaodao.app.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author jack
 * @since 2022-08-02
 */
public class DateTimeUtils {

    /**
     * 默认月份格式
     */
    public static final String MONTH_DEFAULT_FORMAT = "yyyy-MM";

    /**
     * 默认日期格式
     */
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * 其他日期格式
     */
    public static final String DATE_BASE_FORMAT = "yyyy/MM/dd";

    /**
     * 默认日期时间格式
     */
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";

    /**
     * 取默认的系统zone id
     */
    private static final ZoneId ZONE_ID = ZoneId.systemDefault();
    /**
     * 转换LocalDate为Date
     * @param localDate 日期
     * @return 响应结果
     */
    public static Date localDateToUtilDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
    /**
     * 转换LocalDateTime为Date
     *
     * @param localDateTime 日期
     * @return 响应结果
     */
    public static Date localDateTimeToUtilDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换Date为LocalDateTime
     *
     * @param utilDate date
     * @return 响应结果
     */
    public static LocalDateTime utilDateToLocalDateTime(Date utilDate) {
        return LocalDateTime.ofInstant(utilDate.toInstant(), ZoneId.systemDefault());
    }


}
