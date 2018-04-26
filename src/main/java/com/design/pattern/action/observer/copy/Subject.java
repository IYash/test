package com.design.pattern.action.observer.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchangling on 2017/11/10 0010
 * 观察者模式所涉及的角色有：

　　●　　抽象主题(Subject)角色：抽象主题角色把所有对观察者对象的引用保存在一个聚集（比如ArrayList对象）里，每个主题都可以有任何数量的观察者。抽象主题提供一个接口，可以增加和删除观察者对象，抽象主题角色又叫做抽象被观察者(Observable)角色。

　　●　　具体主题(ConcreteSubject)角色：将有关状态存入具体观察者对象；在具体主题的内部状态改变时，给所有登记过的观察者发出通知。具体主题角色又叫做具体被观察者(Concrete Observable)角色。

　　●　　抽象观察者(Observer)角色：为所有的具体观察者定义一个接口，在得到主题的通知时更新自己，这个接口叫做更新接口。

　　●　　具体观察者(ConcreteObserver)角色：存储与主题的状态自恰的状态。具体观察者角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态 像协调。如果需要，具体观察者角色可以保持一个指向具体主题对象的引用。
 */
public abstract class Subject {

    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> list = new ArrayList<>();

    /**
     * 注册观察者对象
     * @param observer
     */
    public void attach(Observer observer){
        list.add(observer);
        System.out.println("attach an observer");
    }

    /**
     * 删除观察者对象
     * @param observer
     */
    public void detach(Observer observer){
        list.remove(observer);
        System.out.println("detach an observer");
    }

    /**
     * 通知所有注册的观察者对象
     * @param newState
     */
    public void notifyObserver(String newState){
        list.stream().forEach(observer ->observer.update(newState));
    }
}
