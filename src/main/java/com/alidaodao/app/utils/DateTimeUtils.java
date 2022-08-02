package com.alidaodao.app.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
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


    /**
     * 计算两个日期中的小时数
     *
     * @param temporal1Inclusive 开始时间
     * @param temporal2Exclusive 结束时间
     * @return 响应结果
     */
    public static long hoursBetween(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
        return ChronoUnit.HOURS.between(temporal1Inclusive, temporal2Exclusive);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param parse
     * @return
     */
    public static String parse(LocalDate date,String parse){
        return date.format(DateTimeFormatter.ofPattern(parse));
    }


}
