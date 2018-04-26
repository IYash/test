package com.design.pattern.action.mediator.copy;

/**
 * @author huangchangling on 2017/11/7 0007
 * 我们使用一个例子来说明一下什么是同事类：有两个类A和B，
 * 类中各有一个数字，并且要保证类B中的数字永远是类A中数字的100倍。
 * 也就是说，当修改类A的数时，将这个数字乘以100赋给类B，而修改类B时，
 * 要将数除以100赋给类A。类A类B互相影响，就称为同事类。
 */
public abstract class AbstractColleague {
    protected int number;

    public int getNumber(){return number;}

    public void setNumber(int number){
        this.number = number;
    }
    //抽象方法，修改数字同时修改关联对象
    public abstract void setNumber(int number,AbstractColleague coll);
}
