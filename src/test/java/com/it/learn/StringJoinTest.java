package com.it.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangchangling on 2017/8/15 0015
 */
public class StringJoinTest {


    @Test
    public void testJoin(){
        String tar = null;

        int bigTitleCount = 1;
        int smallTitleCount = 1;
        int textCount = 1;

        Map<String,String> vom = new HashMap<>();
        List<String>  arrs = new ArrayList<>();

        arrs.add("BIG_TITLE");
        arrs.add("SMALL_TITLE");
        arrs.add("TEXT");
        arrs.add("BIG_TITLE");
        arrs.add("SMALL_TITLE");
        arrs.add("SMALL_TITLE");
        arrs.add("BIG_TITLE");
        arrs.add("TEXT");
        arrs.add("TEXT");
        arrs.add("TEXT");
        arrs.add("BIG_TITLE");
        arrs.add("SMALL_TITLE");

        for (String str: arrs
             ) {
            tar = str;
            switch(tar){
                case "BIG_TITLE": tar += bigTitleCount++; vom.put(tar,str);break;
                case "SMALL_TITLE": tar += smallTitleCount++; vom.put(tar,str);break;
                case "TEXT": tar += textCount++; vom.put(tar,str);break;
            }
        }
        for (String str:
             vom.keySet()) {
            System.out.println("key:"+str+"---->value:"+vom.get(str));
        }
        System.out.println(vom.get("BIG_TITLE"+1));
    }



}
