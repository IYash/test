package com.other;

import org.junit.Test;

/**
 * Created by Administrator on 2018/4/8.
 */
public class NullTest {
    @Test
    public void testNull(){
        String src = null;
        String tar = src;
        System.out.println(tar);
    }
    @Test
    public void testOut(){
        Integer max = Integer.MAX_VALUE;
        System.out.println(max*100);
    }
}
