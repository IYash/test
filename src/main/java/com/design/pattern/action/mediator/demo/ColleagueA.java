package com.design.pattern.action.mediator.demo;

/**
 * @author huangchangling on 2017/11/7 0007
 */
public class ColleagueA extends AbstractColleague {
    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.AaffectB();
    }
}
