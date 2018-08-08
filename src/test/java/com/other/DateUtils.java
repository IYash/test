package com.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by huangchangling on 2018/8/2.
 */

 public class DateUtils {
        //日期格式化字符串
        public static String yyyyMMddStr = "yyyy-MM-dd";
        //时间格式化字符串
        public static String yyyyMMddHHmmssStr = "yyyy-MM-dd HH:mm:ss";
        //日期格式
        public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat(yyyyMMddStr);
        //时间格式
        public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(yyyyMMddHHmmssStr);

        /**
         * 获取添加小时后日期字符
         *
         * @param date
         * @param hours
         * @return
         */
        public static String getAddHoursDateStr(Date date, int hours, String format) {
            if (date == null)
                return null;
            if (format == null)
                format = "yyyy-MM-dd HH:mm:ss";
            Date time = org.apache.commons.lang3.time.DateUtils.addHours(date, hours);
            return new SimpleDateFormat(format).format(time);
        }

    /**
     * 根据当前时间获取下一个4点钟
     * @param date
     * @return
     */
        public static Date getNextDay(Date date){
            if (date == null) return null;
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int hour  = calendar.get(Calendar.HOUR_OF_DAY);
            Date firstDayOfWeek = calendar.getTime();
            Date firstDayOfNextWeek = null;
//            if(hour > 17) {
                firstDayOfNextWeek  = org.apache.commons.lang3.time.DateUtils.addDays(firstDayOfWeek, 1);
//            } else {
//                firstDayOfNextWeek = org.apache.commons.lang3.time.DateUtils.addDays(firstDayOfWeek, 0);
//            }
            return org.apache.commons.lang3.time.DateUtils.truncate(firstDayOfNextWeek, Calendar.DATE);
        }
        /**
         * 获取当下一周的第一天
         *
         * @param date
         * @return
         */
        public static Date getFirstDayOfNextWeek(Date date) {
            if (date == null)
                return null;
            Calendar calendar = new GregorianCalendar();
            calendar.setFirstDayOfWeek(Calendar.SUNDAY);
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
            Date firstDayOfWeek = calendar.getTime();
            Date firstDayOfNextWeek = org.apache.commons.lang3.time.DateUtils.addDays(firstDayOfWeek, 7);
            return org.apache.commons.lang3.time.DateUtils.truncate(firstDayOfNextWeek, Calendar.DATE);
        }

        /**
         * 获取下一月的第一天
         *
         * @param date
         * @return
         */
        public static Date getFirstDayOfNextMonth(Date date) {
            if (date == null)
                return null;
            Date firstDayOfMonth = org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.MONTH);
            Date firstDayOfNextMonth = org.apache.commons.lang3.time.DateUtils.addMonths(firstDayOfMonth, 1);
            return firstDayOfNextMonth;
        }

        /**
         * 获取下一季度的第一天
         *
         * @param date
         * @return
         */
        public static Date getFirstDayOfNextQuarter(Date date) {
            if (date == null)
                return null;
            Calendar current = new GregorianCalendar();
            current.setTime(date);
            int month = current.get(Calendar.MONTH);
            if (Calendar.JANUARY == month || Calendar.FEBRUARY == month || Calendar.MARCH == month) {
                Calendar calendar = new GregorianCalendar();
                calendar.set(Calendar.MONTH, Calendar.APRIL);
                calendar.set(Calendar.DATE, 1);
                return org.apache.commons.lang3.time.DateUtils.truncate(calendar.getTime(), Calendar.DATE);
            } else if (Calendar.APRIL == month || Calendar.MAY == month || Calendar.JUNE == month) {
                Calendar calendar = new GregorianCalendar();
                calendar.set(Calendar.MONTH, Calendar.JULY);
                calendar.set(Calendar.DATE, 1);
                return org.apache.commons.lang3.time.DateUtils.truncate(calendar.getTime(), Calendar.DATE);
            } else if (Calendar.JULY == month || Calendar.AUGUST == month || Calendar.SEPTEMBER == month) {
                Calendar calendar = new GregorianCalendar();
                calendar.set(Calendar.MONTH, Calendar.OCTOBER);
                calendar.set(Calendar.DATE, 1);
                return org.apache.commons.lang3.time.DateUtils.truncate(calendar.getTime(), Calendar.DATE);
            } else if (Calendar.OCTOBER == month || Calendar.NOVEMBER == month || Calendar.DECEMBER == month) {
                Calendar calendar = new GregorianCalendar();
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
                calendar.set(Calendar.DATE, 1);
                Date firstDayOfNextYear = org.apache.commons.lang3.time.DateUtils.addYears(calendar.getTime(), 1);
                return org.apache.commons.lang3.time.DateUtils.truncate(firstDayOfNextYear, Calendar.DATE);
            }
            return null;
        }

        /**
         * 获取下一年的第一天
         *
         * @param date
         * @return
         */
        public static Date getFirstDayOfNextYear(Date date) {
            if (date == null)
                return null;
            Date firstDayOfYear = org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.YEAR);
            Date firstDayOfNextYear = org.apache.commons.lang3.time.DateUtils.addYears(firstDayOfYear, 1);
            return firstDayOfNextYear;
        }

        public static Date parse(String dateStr) {
            try {
                return yyyyMMddHHmmss.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

