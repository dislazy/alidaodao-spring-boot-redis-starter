package com.alidaodao.app.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

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

    /**
     * 获取两个日期之间的所有天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 响应结果
     */
    public static List<String> getDayRegions(String start, String end) {
        List<String> times = new ArrayList<String>();
        try {
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);
            long distance = ChronoUnit.DAYS.between(startDate, endDate);
            if (distance < 1L) {
                times.add(startDate.toString());
                return times;
            }
            Stream.iterate(startDate, d -> d.plusDays(1L)).limit(distance + 1L).forEach(f -> times.add(f.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }

    /**
     * 获取日期中的周一
     *
     * @param date 日期
     * @return 响应结果
     */
    public static String getCurrWeekMonday(String date) {
        if (org.apache.commons.lang3.StringUtils.isBlank((CharSequence) date)) {
            return null;
        }
        try {
            LocalDate beginDateTime = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate monday = beginDateTime.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1L);
            return monday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取日期中的周日
     *
     * @param date 日期
     * @return 响应结果
     */
    public static String getCurrWeekSunDay(String date) {
        if (StringUtils.isBlank((CharSequence) date)) {
            return null;
        }
        try {
            LocalDate beginDateTime = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate monday = beginDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1L);
            return monday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串日期转换为时间戳
     * @param text
     * @return
     */
    public static long stringToMillisecond(String text) {
        long milli = 0;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_MINUTE_FORMAT);
            LocalDateTime localDateTime1 = LocalDateTime.parse(text, formatter);
            milli = LocalDateTime.from(localDateTime1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        } catch (Exception e) {
            return 0;
        }
        return milli;
    }


    /**
     * 日期时间转化为时间戳
     *
     * @param datetime 日期时间
     * @return 响应结果
     */
    public static long localDateTimeToMillisecond(LocalDateTime datetime) {
        return datetime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 日期转化为时间戳
     *
     * @param date 日期
     * @return 响应结果
     */
    public static long localDateToMillisecond(LocalDate date) {
        return date.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * 时间戳转化为日期时间
     *
     * @param timestamp 时间戳
     * @return 响应结果
     */
    public static LocalDateTime millisecondToLocalDateTime(Long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * 时间戳转化为日期
     *
     * @param timestamp 时间戳
     * @return 响应结果
     */
    public static LocalDate millisecondToLocalDate(Long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }


    /**
     * 根据给定parrern从字符串解析出Date
     *
     * @param pattern 格式
     * @param text    日期字符串
     * @return 日期
     */
    public static Date parse(String pattern, String text) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dest;
        // 仅判断结尾的dd 一定隐含了部分特殊pattern解析不能的错误
        // 权且先这样处理 有待改进
        String dateEndWith = "dd";
        if (pattern.trim().endsWith(dateEndWith)) {
            dest = LocalDate.parse(text, formatter).atStartOfDay();
        } else {
            dest = LocalDateTime.parse(text, formatter);
        }

        return Date.from(dest.atZone(ZONE_ID).toInstant());
    }

    /**
     * 从字符串解析出Date
     *
     * @param text
     * @return
     */
    public static Date parseDate(String text) {
        return parse(DATE_DEFAULT_FORMAT, text);
    }

    /**
     * 从字符串解析出Date
     *
     * @param text
     * @return
     */
    public static Date parseDateTime(String text) {
        return parse(DATETIME_DEFAULT_FORMAT, text);
    }

    /**
     * 根据给定parrern从Date解析出字符串
     *
     * @param pattern 格式
     * @param date    日期
     * @return 日期字符串
     */
    public static String format(String pattern, Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dest = LocalDateTime.ofInstant(date.toInstant(), ZONE_ID);

        return formatter.format(dest);
    }


    public static void main(String[] args) {
        //parse
        System.out.println(parse(LocalDate.now(),DATE_BASE_FORMAT));

        //date
        System.out.println(dateFormat(LocalDate.now(),DATE_BASE_FORMAT));

        //utils
        System.out.println(localDateToUtilDate(LocalDate.now()));


        //config
        System.out.println(parseToLocalDate("2022-10-02",DATE_DEFAULT_FORMAT));

    }
}
