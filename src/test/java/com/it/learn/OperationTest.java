package com.it.learn;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangchangling on 2017/6/8 0008
 *
 * @Description base operation test
 */
public class OperationTest {

    public static int CAPACITY = 536870911;

    public static int CAPACITY_NEG = ~CAPACITY;

    public final AtomicInteger ctl = new AtomicInteger(CAPACITY_NEG);
    @Test
    public void testNegation(){
        int ori = 1; //有符号

        int ret = ~ori;

        System.out.println(Integer.MAX_VALUE);

        System.out.println(Integer.MIN_VALUE);

        System.out.println(ret);
    }

    @Test
    public void testNegation_1(){

        int count = 4;

        System.out.println(Integer.toBinaryString(CAPACITY)+"===capacity===BinaryString");

        System.out.println(Integer.toBinaryString(CAPACITY_NEG)+"===capacity_neg===BinaryString");

        while(count > 0) {

            int ori = ctl.get();

            System.out.println(ori);

            System.out.println(Integer.toBinaryString(ori)+"===ori===BinaryString");

            int runState = runStateOf(ori);

            int workerCount = workerCountOf(ori);

            System.out.println(runState + "===COUNT"+count+"===" + workerCount);

            count--;

            compareAndSet(ori);
        }
    }
    private static int runStateOf(int c) {

        return c & CAPACITY_NEG;
    }
    private static int workerCountOf(int c) {

        return c & CAPACITY;
    }
    private boolean compareAndSet(int expect){

        return ctl.compareAndSet(expect,expect + 1);
    }
}
