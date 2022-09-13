package com.alidaodao.app.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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


    /**
     * 计算两个日期中的分钟数
     *
     * @param temporal1Inclusive 开始时间
     * @param temporal2Exclusive 结束时间
     * @return 响应结果
     */
    public static long minutesBetween(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
        return ChronoUnit.MINUTES.between(temporal1Inclusive, temporal2Exclusive);
    }

    /**
     * 计算两个日期中的秒数
     *
     * @param temporal1Inclusive 开始时间
     * @param temporal2Exclusive 结束时间
     * @return 响应结果
     */
    public static long secondsBetween(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
        return ChronoUnit.SECONDS.between(temporal1Inclusive, temporal2Exclusive);
    }

    /**
     * 日期时间格式化
     *
     * @param dateTime 日期时间
     * @param format   格式
     * @return 响应结果
     */
    public static String dateTimeFormat(LocalDateTime dateTime, String format) {
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }



    /**
     * 日期格式化
     *
     * @param date   日期
     * @param format 格式
     * @return 响应结果
     */
    public static String dateFormat(LocalDate date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 时间格式化
     *
     * @param time   时间
     * @param format 格式
     * @return 响应结果
     */
    public static String timeFormat(LocalTime time, String format) {
        return time.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 转化String为日期时间
     *
     * @param text   日期内容
     * @param format 格式
     * @return 响应结果
     */
    public static LocalDateTime parseToLocalDateTime(String text, String format) {
        return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(format));
    }

    /**
     * 转化String为日期
     *
     * @param text   日期内容
     * @param format 格式
     * @return 响应结果
     */
    public static LocalDate parseToLocalDate(String text, String format) {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(format));
    }

    public static void main(String[] args) {
        System.out.println(parse(LocalDate.now(),DATE_BASE_FORMAT));
    }
}
