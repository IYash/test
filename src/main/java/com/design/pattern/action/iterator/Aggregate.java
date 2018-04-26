package com.design.pattern.action.iterator;

/**
 * @author huangchangling on 2017/11/6 0006
 * 迭代子模式涉及到以下几个角色：

　　●　　抽象迭代子(Iterator)角色：此抽象角色定义出遍历元素所需的接口。

　　●　　具体迭代子(ConcreteIterator)角色：此角色实现了Iterator接口，并保持迭代过程中的游标位置。

　　●　　聚集(Aggregate)角色：此抽象角色给出创建迭代子(Iterator)对象的接口。

　　●　　具体聚集(ConcreteAggregate)角色：实现了创建迭代子(Iterator)对象的接口，返回一个合适的具体迭代子实例。

　　●　　客户端(Client)角色：持有对聚集及其迭代子对象的引用，调用迭代子对象的迭代接口，也有可能通过迭代子操作聚集元素的增加和删除。

        抽象聚集角色类，这个角色规定出所有的具体聚集必须实现的接口。迭代子模式要求聚集对象必须有一个工厂方法，也就是createIterator()方法，以向外界提供迭代子对象的实例
 */
public abstract class Aggregate {

    /**
     * 工厂方法，创建相应迭代子对象的接口
     * @return
     */
    public abstract com.design.pattern.action.iterator.Iterator createIterator();
}
