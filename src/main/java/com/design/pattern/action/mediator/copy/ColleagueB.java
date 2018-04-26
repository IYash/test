package com.design.pattern.action.mediator.copy;

/**
 * @author huangchangling on 2017/11/7 0007
 */
public class ColleagueB extends AbstractColleague {
    @Override
    public void setNumber(int number, AbstractColleague coll) {
        this.number = number;
        coll.setNumber(number/100);
    }
}
