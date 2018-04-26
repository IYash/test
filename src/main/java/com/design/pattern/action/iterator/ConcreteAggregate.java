package com.design.pattern.action.iterator;




/**
 * @author huangchangling on 2017/11/6 0006
 * 具体聚集角色类，实现了抽象聚集角色类所要求的接口，也就是createIterator()方法。此外，还有getElement()向外界提供聚集元素，而方法size()向外界提供聚集的大小等
 */
public class ConcreteAggregate extends Aggregate {

    private Object[] objArray = null;

    /**
     * 构造方法，传入聚合对象的具体内容
     * @param objArray
     */
    public ConcreteAggregate(Object[] objArray) {
        this.objArray = objArray;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    /**
     * 取值方法：向外界提供聚集元素
     * @param index
     * @return
     */
    public Object getElement(int index){
        if(index < objArray.length) return objArray[index];
        return null;
    }

    public int size(){
        return objArray.length;
    }
}
