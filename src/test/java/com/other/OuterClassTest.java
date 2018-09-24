package com.other;

import com.test.innerclass.OuterClass;
import org.junit.Test;

/**
 * Created by huangchangling on 2018/9/24.
 */
public class OuterClassTest {
    @Test
    public void testCreate(){
        OuterClass.InnerClass ic = new OuterClass().new InnerClass();
        OuterClass.SInnerClass isc = new OuterClass.SInnerClass();
    }
}
