package com.it.learn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchangling on 2017/6/28 0028
 */
public class HashMapTest {

    @Test
    public void testNull(){
        Map m = new HashMap();

        m.put(null,null);

        System.out.println("=====this is ok.....");
    }
}
