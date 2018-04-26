package com.test.oop;

/**
 * @author huangchangling on 2017/7/3 0003
 */
public class TBase<T extends Base> implements ITBase<T>{

    //目标处理对象
    private T target;

    public TBase(T target){

        this.target = target;

    }

    public void common(){

        target.common(target.getDescription(),target.getObjectId());

    }
}
