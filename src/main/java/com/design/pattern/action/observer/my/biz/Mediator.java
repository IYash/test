package com.design.pattern.action.observer.my.biz;

import com.design.pattern.action.observer.my.entity.Subject;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public abstract class Mediator {

    protected Subject subject;

    protected Observer observer ;

    public void attachObserver(Observer observer){
        this.observer = observer;
    }
}
