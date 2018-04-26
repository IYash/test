package com.other;

import org.junit.Test;

/**
 * @author huangchangling on 2017/12/21 0021
 */
public class FinallyTest {
    @Test public void test(){
        System.out.println(testFinally());
    }

    private  int testFinally(){
      try {
          System.out.println("try");
          return 1;
          } catch (Exception e) {
          return -1;
          } finally{
          System.out.println("finally");
          return 0;
          }
        }
}
