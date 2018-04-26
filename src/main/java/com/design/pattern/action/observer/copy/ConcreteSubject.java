package com.design.pattern.action.observer.copy;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState(){return state;}

    public void change(String newState){
        state = newState;
        System.out.println("主题状体为："+state);
        //状态发生改变，通知各个观察者
        this.notifyObserver(state);
    }
}
