package com.func.exercise;

import com.fun.MathFun;
import org.junit.Test;

/**
 * @author huangchangling on 2017/9/8 0008
 */
public class CapTwoExercise {
    @Test
    public void testMaxFactor(){
        long m =30;
        long n =9;
        System.out.println(MathFun.maxFactor(30,9));
    }
    @Test
    public void testPower(){
        long a =2;
        int b = 1;
        System.out.println(MathFun.power(a,b));
    }
}
