package com.design.pattern.action.strategy;

/**
 * Created by huangchangling on 2018/5/7.
 */
public class Context {
    //持有一个具体策略的对象
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 策略方法
     */
    public void contextInterface(){
        strategy.strategyInterface();
    }

}
