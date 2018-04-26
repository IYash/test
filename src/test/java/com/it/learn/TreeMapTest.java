package com.it.learn;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author huangchangling on 2017/8/11 0011
 */
public class TreeMapTest {

    @Test
    public void TestPut(){
        //序列5,4,6,9,7,10
        Map<Integer,String> tm = new TreeMap<>();

//        tm.put(5,"5");
//
//        tm.put(4,"4");
//
//        tm.put(6,"6");
//
//        tm.put(9,"9");
//
//        tm.put(7,"7");
//
//        tm.put(10,"10");
//
//        tm.put(11,"11");
//
//        tm.put(8,"8");
        //序列7,5,6
        tm.put(7,"7");
        tm.put(5,"5");
        tm.put(6,"6");


    }
}
