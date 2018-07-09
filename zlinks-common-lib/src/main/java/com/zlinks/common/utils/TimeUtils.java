package com.zlinks.common.utils;


import com.zlinks.common.constants.BaseResultCodeConstant;
import com.zlinks.common.exception.BusinessException;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by apple on 17/3/31.
 *
 * @author vincent
 */
public class TimeUtils {

    private static Logger logger = LoggerFactory.getLogger(TimeUtils.class.getName());

    public enum DateFormatType {
        HourMinute12,
        HourMinute24,
        DateTime,
        DateTimeChinese,
        Date,
        DateNoHyphen,
        DateTimeNoHyphen,
        DateChinese,
        DateSlash,
        SimpleDateChinese,
        Time24,
        Time12,
        Year,
        Month,
        Day,
        Hour24,
        Hour12,
        Minute,
        Second,
        DateTimeToMin;

        public SimpleDateFormat getType() {
            switch (this) {
                case Date:
                    return new SimpleDateFormat("yyyy-MM-dd");
                case DateTime:
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                case DateNoHyphen:
                    return new SimpleDateFormat("yyyyMMdd");
                case DateSlash:
                    return new SimpleDateFormat("yyyy/MM/dd");
                case HourMinute12:
                    return new SimpleDateFormat("hh:mm");
                case DateTimeNoHyphen:
                    return new SimpleDateFormat("yyyyMMddHHmmss");
                case Year:
                    return new SimpleDateFormat("yyyy");
                case Month:
                    return new SimpleDateFormat("mm");
                case Day:
                    return new SimpleDateFormat("dd");
                case Hour24:
                    return new SimpleDateFormat("HH");
                case Hour12:
                    return new SimpleDateFormat("hh");
                case Minute:
                    return new SimpleDateFormat("mm");
                case Second:
                    return new SimpleDateFormat("ss");
                case DateTimeChinese:
                    return new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
                case SimpleDateChinese:
                    return new SimpleDateFormat("MM月dd日");
                case DateChinese:
                    return new SimpleDateFormat("yyyy年MM月dd日");
                case Time24:
                    return new SimpleDateFormat("HH:mm:ss");
                case Time12:
                    return new SimpleDateFormat("hh:mm:ss");
                case HourMinute24:
                    return new SimpleDateFormat("HH:mm");
                case DateTimeToMin:
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                default:
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
        }
    }


    public static String dateToStr(Date date, DateFormatType type) {
        return type.getType().format(date);
    }


    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static long getTimestamp() {
        return System.currentTimeMillis();
    }


    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    private static final String dtLong = "yyyyMMddHHmmss";

    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
     *
     * @return 以yyyyMMddHHmmss为格式的当前系统时间
     */
    public static String getDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }

    /**
     * 传入string type date转long
     */
    public static long geLongDate(String date, String dateformat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        Date dateStr = null;
        try {
            dateStr = sdf.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException(BaseResultCodeConstant.FAILED.getCode(), e.getMessage());
        }
        return dateStr.getTime();
    }

    /**
     * 获取指定时间前后某一天
     * date 为 null,默认使用当前时间
     *
     * @param date
     * @param days 负数前面几天，正数后面几天
     * @return
     */
    public static Date getExpireDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            calendar.add(Calendar.DATE, days);
            return calendar.getTime();
        }
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        Date newDate = calendar.getTime();
        return newDate;
    }

//    public static void main(String[] args) {
////        Date date = TimeUtils.getExpireDate(new Date(), -2);
////        System.out.println(getBeginTimeOfDay(date));
////        System.out.println(getEndTimeOfDay(date));
////        System.out.println("------------"+TimeUtils.geLongDate(getBeginTimeOfDay(date), "yyyy-MM-dd HH:mm:ss"));
////        System.out.println("==========12===="+TimeUtils.getTimeStampTime(getBeginTimeOfDay(date)));
//        Date date = stringDateToDate("2017-11-12 14:46:08");
//        System.out.println("==========123====" + date);
//    }


    // 获取指定日期的开始时间最初一秒 例如：2017-11-11 00:00:00
    public static String getBeginTimeOfDay(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = DateFormatUtils.format(date, "yyyy-MM-dd 00:00:00");
        }
        return dateStr;
    }

    //获取指定日期的结束时间最后一秒 例如:2017-11-11 23:59:59
    public static String getEndTimeOfDay(Date date) {
        String dateStr = null;
        if (date != null) {
            dateStr = DateFormatUtils.format(date, "yyyy-MM-dd 23:59:59");
        }
        return dateStr;
    }

    //string日期格式转date
    public static Date stringDateToDate(String dateStr) {
        Date date = null;
        try {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            date = fmt.parse(dateStr);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException(BaseResultCodeConstant.FAILED.getCode(), e.getMessage());
        }
        return date;
    }

    //long时间转stringDate 例如： 1512229367036 转成 2018-01-14 17:15:05
    public static String longDateToStrDate(long time, String dateFormat) {
        String returnDateStr = null;
        try {
            Date dateStr = new Date(time);
            DateFormat df = new SimpleDateFormat(dateFormat);
            returnDateStr = df.format(dateStr);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnDateStr;
    }

}
