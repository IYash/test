package com.it.learn;


import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huangchangling on 2017/7/19 0019
 */
public class ListTest {

    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Test
    public void testAddAll(){

        List<String> dateStr = new ArrayList<>();


        List<String> dateStr1 = new ArrayList<>();
        List<String> dateStr2 = new ArrayList<>();
        List<String> dateStr3 = new ArrayList<>();

        dateStr1.add("2017-01-02");
        dateStr1.add("2017-01-03");
        dateStr1.add("2017-01-04");

        dateStr2.add("2017-01-05");
        dateStr2.add("2017-01-06");
        dateStr2.add("2017-01-07");

        dateStr3.add("2017-01-08");
        dateStr3.add("2017-01-09");
        dateStr3.add("2017-01-10");

        dateStr.addAll(dateStr1);
        dateStr.addAll(dateStr2);
        dateStr.addAll(dateStr3);

        String need = StringUtils.join(dateStr,";");

        System.out.println(need);

    }
    @Test
    public void testSubList(){
        List<String> dateStr1 = new ArrayList<>();
        dateStr1.add("2017-01-02");
        dateStr1.add("2017-01-03");
        dateStr1.add("2017-01-04");

        Iterator<String> its = dateStr1.iterator();

        while(its.hasNext()) {

            String ele = its.next();

            if ("2017-01-03".equals(ele)) its.remove();

            System.out.println(ele);
        }

        List<String> subList = dateStr1.subList(0,2);

        subList.set(0,"2017-01-05");

        System.out.println(dateStr1.get(0) + "--------->" + subList.get(0));

    }

    @Test
    public void testZeroSize(){

        List<String> arr = new ArrayList<>();

        System.out.println(arr.contains("1"));

        System.out.println(arr.isEmpty());
    }

    @Test
    public void testIsMobile(){
        String mobile = "+8613812121212";
        String mobile1 = "8613812121212";
        String mobile2 = "13812121212";
        String mobile3 = "8713812121212";

        System.out.println(isMobile(mobile));
        System.out.println(isMobile(mobile1));
        System.out.println(isMobile(mobile2));
        System.out.println(isMobile(mobile3));

    }
    private boolean isMobile(String mobile) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^((\\+86)|(86))?[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(mobile);
        b = m.matches();
        return b;
    }

}
