package com.test.lambda.interface1;

/**
 * @author huangchangling on 2017/7/13 0013
 */
public interface Parent {

    public void message(String body);

    public default void welcome(){
        message("Parent:Hi!");
    }
    public String getLastMessage();
}
