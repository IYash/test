package com.it.learn;

import org.junit.Test;

/**
 * @author huangchangling on 2017/8/5 0005
 */
public class URITest {
    


    private String uri = "/servlet/app;jsessionId=1254354?username=used&password=123";

    @Test
    public void testUri(){

        String match = ";jsessionId=";
        int index = uri.indexOf(match);
        System.out.println(index);

        if(index >= 0) {
            String rest = uri.substring(index + match.length());
            System.out.println(rest);
        }

    }
}
