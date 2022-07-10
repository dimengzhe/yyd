package com.yxt.yyd.common.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author dimengzhe
 * @Date 2021/11/7 11:58
 * @Description 关于日期处理工具类
 */
public class DateUtils {

    public static void main(String[] args) throws Exception {
        //时间格式字符串转换成Date类型
        Date date = dateStrConvertDateCst("2021-11-07 12:28:20", "yyyy-MM-dd HH:mm:ss");
        //获取两个时间间隔的x天x小时x分钟
        System.out.println(getDatePoor(date, new Date()));
        //将Date类型转换成字符串类型
        System.out.println(dateConvertStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 获取两个时间间隔的x天x小时x分钟
     *
     * @param endDate 结尾时间
     * @param nowDate 当前时间
     * @return
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒
        long s = diff % nd % nh % nm / ns;
        // 输出结果
        return day + "天" + hour + "小时" + min + "分钟" + s + "秒";
    }

    /**
     * 时间格式字符串转换成Date类型
     *
     * @param date   时间字符串
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date dateStrConvertDateCst(String date, String format) {
        try {
            SimpleDateFormat simpledateformat = new SimpleDateFormat(format,
                    Locale.US);
            Date newDate = simpledateformat.parse(date);
            return newDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 将Date类型转换成字符串类型
     *
     * @param date   时间
     * @param format 格式
     * @return
     */
    public static String dateConvertStr(Date date, String format) {
        return (date == null) ? null : new SimpleDateFormat(format)
                .format(date);
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }
}
