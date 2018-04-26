package com.it.learn;

import org.junit.Test;

/**
 * @author huangchangling on 2017/8/17 0017
 */
public class EnumTest {

    @Test
    public void testEnum(){

        Food[] values = Food.values();
        for (Food food: values
             ) {
            System.out.println(food + "---->" + food.getCname());
        }

    }


}
