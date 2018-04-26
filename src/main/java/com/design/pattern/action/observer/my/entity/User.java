package com.design.pattern.action.observer.my.entity;


import com.design.pattern.action.observer.my.biz.Mediator;
import com.design.pattern.action.observer.my.biz.UserMediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public class User extends Subject{

    private String name;

    private Map<String,Object> selfdom = new HashMap<>();//定制个人信息

    private Mediator mediator;

    public User(Mediator mediator){
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getSelfdom() {
        return selfdom;
    }

    public void individual(String key, Object obj){
        selfdom.put(key,obj);
    }
    public void init() {
        selfdom = new HashMap<>();
    }

    public void publish(){
        ((UserMediator)mediator).attachPubisher(this);
    }
    public void subscribe(){
        ((UserMediator)mediator).attachSubscriber(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
