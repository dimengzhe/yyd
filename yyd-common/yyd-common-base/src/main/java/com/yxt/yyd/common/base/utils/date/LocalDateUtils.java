package com.yxt.yyd.common.base.utils.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author dimengzhe
 * @Date 2021/11/6 22:52
 * @Description java 8 日期工具类再封装
 */
public class LocalDateUtils {

    /**
     * 比较第一个日期是否小于第二个日期
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return true-小于;false-大于
     */
    public static boolean localDateIsBefore(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isBefore(secondDate);
    }


    /**
     * 比较第一个日期是否大于第二个日期
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return true-大于;false-不大于
     */
    public static boolean localDateIsAfter(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isAfter(secondDate);
    }

    /**
     * 比较两个日期是否相等
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return true-相等;false-不相等
     */
    public static boolean localDateIsEqual(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isEqual(secondDate);
    }


    /**
     * 字符串转换datetime
     *
     * @param dateTime
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static Date stringCoverDateTime(String dateTime) {
        LocalDateTime startDateTime =
                LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Date LocalDateTimeToDate = Date.from(startDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return LocalDateTimeToDate;
    }


    /**
     * 字符串转换date
     *
     * @param dateTime
     * @return yyyy-MM-dd
     */
    public static Date stringCoverDate(String dateTime) {
        LocalDateTime startDateTime =
                LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date LocalDateTimeToDate = Date.from(startDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return LocalDateTimeToDate;
    }
}
