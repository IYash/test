package com.other;

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
}
