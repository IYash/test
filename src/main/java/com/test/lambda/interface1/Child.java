package com.test.lambda.interface1;

/**
 * @author huangchangling on 2017/7/13 0013
 */
public interface Child extends Parent {
    @Override
    public default void welcome(){
        message("Child:Hi!");
    }
}
