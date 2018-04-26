package com.it.learn;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangchangling on 2017/8/28 0028
 */
public class CHMTest {


    @Test
    public void testPut(){

        Map<String,Integer> chm = new ConcurrentHashMap<>();

        //chm.put(null,null);
        chm.put("first",1);
        chm.put("second",2);
        chm.put("three",3);

        System.out.println(chm.get("second"));

    }
}
