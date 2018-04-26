package com.design.pattern.action.observer.copy;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public class PullConcreteSubject extends PullSubject {

    private String state;

    public String getState(){
        return state;
    }
    public void change(String newState){
        this.state = newState;
        this.notifyPullObservers();
    }
}
