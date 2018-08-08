package com.other;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huangchangling on 2018/5/15.
 */
public class DateUtil {
    private static final String PATTERN = "yyyyMMddHHmmss";
    DateFormat sdf  = new SimpleDateFormat(PATTERN);
    @Test
    public void testFormat(){
        String f = sdf.format(new Date());
        System.out.println(f);
    }
    @Test
    public void testDate(){
       Date date = null;//DateUtils.getFirstDayOfNextMonth(new Date())
        //date = DateUtils.getFirstDayOfNextWeek(new Date());
        date = DateUtils.getNextDay(new Date());
       System.out.println(DateUtils.getAddHoursDateStr(date, 4, DateUtils.yyyyMMddHHmmssStr));
        date = DateUtils.getFirstDayOfNextWeek(new Date());
        System.out.println(DateUtils.getAddHoursDateStr(date, 4, DateUtils.yyyyMMddHHmmssStr));
        date = DateUtils.getFirstDayOfNextMonth(new Date());
        System.out.println(DateUtils.getAddHoursDateStr(date, 4, DateUtils.yyyyMMddHHmmssStr));
        date = DateUtils.getFirstDayOfNextQuarter(new Date());
        System.out.println(DateUtils.getAddHoursDateStr(date, 4, DateUtils.yyyyMMddHHmmssStr));
        date = DateUtils.getFirstDayOfNextYear(new Date());
        System.out.println(DateUtils.getAddHoursDateStr(date, 4, DateUtils.yyyyMMddHHmmssStr));
    }

    @Test
    public void testDate1(){
        Date executeDate = null;
        Date begin = null;
        Date endD = null;
        //按周
        executeDate = DateUtils.parse("2018-07-29 04:00:00");
        begin = org.apache.commons.lang3.time.DateUtils.addWeeks(executeDate, -1);
        endD = org.apache.commons.lang3.time.DateUtils.addDays(executeDate, -1);
        System.out.println(DateUtils.yyyyMMdd.format(new Date(begin.getTime())));
        System.out.println(DateUtils.yyyyMMdd.format(new Date(endD.getTime())));
        //按月
        executeDate = DateUtils.parse("2018-08-01 04:00:00");
        begin = org.apache.commons.lang3.time.DateUtils.addMonths(executeDate, -1);
        endD = org.apache.commons.lang3.time.DateUtils.addDays(executeDate, -1);
        System.out.println(DateUtils.yyyyMMdd.format(new Date(begin.getTime())));
        System.out.println(DateUtils.yyyyMMdd.format(new Date(endD.getTime())));
        //按季度,年
//        executeDate = DateUtils.parse("2018-01-01 00:00:00");
//        int j =12;
//        for (int i=1;i<=j;i++) {
//            begin = org.apache.commons.lang3.time.DateUtils.addMonths(executeDate, -1 * i);
//            endD = org.apache.commons.lang3.time.DateUtils.addMonths(begin, 1);
//            endD = org.apache.commons.lang3.time.DateUtils.addDays(endD,-1);
//            System.out.println(DateUtils.yyyyMMdd.format(new Date(begin.getTime())));
//            System.out.println(DateUtils.yyyyMMdd.format(new Date(endD.getTime())));
//            System.out.println("===========================");
//        }
    }

    @Test
    public void testApi(){
        Date date = DateUtils.getNextDay(new Date());
        date = org.apache.commons.lang3.time.DateUtils.addDays(date, -1);
        System.out.println(date);
    }
    @Test
    public void testChar(){
        String _aa = "_1234";
        String aa = "1234_3";
        String bb = "123";
        System.out.println(_aa.indexOf("_"));
        System.out.println(aa.indexOf("_"));
        System.out.println(bb.indexOf("_"));
        System.out.println(StringUtils.isNotEmpty(""));
    }

}
