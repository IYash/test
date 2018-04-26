package com.it.learn.to8;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author huangchangling on 2017/7/10 0010
 */
public class OptionalTest {

    @Test
    public void testOptional(){

        Optional<String> a = Optional.of("a");//Optional对象相当于值的容器，可通过get获取值
        assertEquals("a",a.get());
    }
    @Test
    public void testNil(){

        List<String> sl = new ArrayList<>();
        String a = null;
       // String ss = a.toString();//NullPointException
        sl.add(a);
        sl.add("hi");
        System.out.println(sl.size());
        System.out.println(sl.get(0));
    }

}
