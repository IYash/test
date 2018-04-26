package com.design.pattern.action.iterator;



/**
 * @author huangchangling on 2017/11/6 0006
 * 具体迭代子角色类
 */
public class ConcreteIterator implements Iterator {
    //持有被迭代的具体的聚合对象
    private ConcreteAggregate agg;
    //内部索引，记录当前迭代到的索引位置
    private int index = 0;
    //记录当前聚集对象的大小
    private int size = 0;
    public ConcreteIterator(ConcreteAggregate agg) {
        this.agg = agg;
        this.size = agg.size();
        this.index = 0;
    }

    /**
     * 迭代方法：移动到第一个元素
     */
    @Override
    public void first() {
        index = 0;
    }

    /**
     * 迭代方法：移动到下一个元素
     */
    @Override
    public void next() {
        if(index < size) index++;
    }
 
    /**
     * 是否为最后一个元素
     * @return
     */
    @Override
    public boolean isDone() {
        return index >= size;
    }

    @Override
    public Object currentItem() {
        return agg.getElement(index);
    }
}
