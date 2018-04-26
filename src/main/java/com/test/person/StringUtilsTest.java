package com.test.person;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchangling
 */
public class StringUtilsTest {

    public static void main(String[] args) {
        List<String> arrs = new ArrayList<String>();
        arrs.add("hello");
        arrs.add("world");
        arrs.add("hi");
        arrs.add("nature");
        String ret = StringUtils.join(arrs,"-----");
        System.out.println(ret);
    }
}
