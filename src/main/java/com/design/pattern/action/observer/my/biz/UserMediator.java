package com.design.pattern.action.observer.my.biz;


import com.design.pattern.action.observer.my.entity.Notify;
import com.design.pattern.action.observer.my.entity.User;

/**
 * @author huangchangling on 2017/11/10 0010
 * 中介对象，充当订阅器使用，发布和订阅者通过这个对象解耦,推模型
 */
public class UserMediator extends Mediator{

    public UserMediator(){
        //构建生产者消费者模型，完成用户订阅数据的拉取（生产），移除已拉取的数据（消费）

    }
    public  void attachPubisher(User target){
        //创建用户
        ServiceMediator.notifyService.createUser(target);
        //创建提醒
        ((UserObserver)observer).publish(target);
    }

    public  void attachSubscriber(User target){
        //创建用户
        ServiceMediator.notifyService.createUser(target);
        //创建订阅信息
        ((UserObserver)observer).subscribe(target);
    }


}
