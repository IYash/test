package com.design.pattern.action.observer.copy;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public class PullConcreteObserver implements PullObserver {

    private String observerState;
    @Override
    public void update(PullSubject subject) {
        observerState = ((PullConcreteSubject)subject).getState();
        System.out.println("观察者状态为:"+observerState);
    }
}
