package com.test.lambda.impl4inteface;

/**
 * @author huangchangling on 2017/7/13 0013
 */
public class OverridingParent extends ParentImpl {
    @Override
    public void welcome(){
        message("Class Parent:Hi!");
    }
}
