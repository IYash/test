package com.design.pattern.action.observer.copy;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public class ConcreteObserver implements Observer {

    private String state;
    @Override
    public void update(String state) {
            this.state = state;
        System.out.println("状态为："+state);
    }
}
