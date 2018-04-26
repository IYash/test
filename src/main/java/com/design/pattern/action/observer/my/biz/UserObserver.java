package com.design.pattern.action.observer.my.biz;


import com.design.pattern.action.observer.my.biz.common.CommonConstant;
import com.design.pattern.action.observer.my.biz.common.GenerateId;
import com.design.pattern.action.observer.my.entity.Notify;
import com.design.pattern.action.observer.my.entity.Subscription;
import com.design.pattern.action.observer.my.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public class UserObserver implements Observer<User> {

    @Override
    public void update(User user) {

    }

    public void subscribe(User user){
        List<Subscription> subscriptions = parseUserSelfdom4sub(user);
        subscriptions.stream().forEach(subscription -> ServiceMediator.notifyService.subscribe(subscription));
    }
    public void publish(User user){
        Notify notify = parseUserSelfdom4pub(user);
        ServiceMediator.notifyService.createNotify(notify);
        //通知拉取提醒
    }

    private Notify parseUserSelfdom4pub(User user) {
        Map<String,Object> selfdom = user.getSelfdom();
        Integer target =(Integer)selfdom.get(CommonConstant.TARGET);
        String targetType = (String)selfdom.get(CommonConstant.TARGET_TYPE);
        String action = (String)selfdom.get(CommonConstant.ACTION);
        String content = (String)selfdom.get(CommonConstant.CONTENT);
        String type = (String)selfdom.get(CommonConstant.TYPE);
        return constructNotify(user.getId(),content,type,target,targetType,action);
    }

    private Notify constructNotify(long id, String content, String type, Integer target, String targetType, String action) {
        Notify notify = new Notify();
        notify.setId(GenerateId.INSTANCE.nextId(notify));
        notify.setContent(content);
        notify.setType(type);
        notify.setTarget(target);
        notify.setTargetType(targetType);
        notify.setSender(id);
        notify.setAction(action);
        return notify;
    }


    @Override
    public Class getType() {
        return User.class;
    }

    private List<Subscription> parseUserSelfdom4sub(User user) {

        List<Subscription> subscriptions = new ArrayList<>();
        Map<String,Object> selfdom = user.getSelfdom();
        Integer target =(Integer)selfdom.get(CommonConstant.TARGET);
        String targetType = (String)selfdom.get(CommonConstant.TARGET_TYPE);
        String action = (String)selfdom.get(CommonConstant.ACTION);
        constructSubs(target,targetType,action,user.getId(),subscriptions);
        return subscriptions;

    }

    private void constructSubs(Integer target, String targetType, String action, long userId,List<Subscription> subscriptions) {
        if(target == null) {
            System.out.println(CommonConstant.TARGET+" can't be null");return;
        }
        String[] acts = action.split(CommonConstant.SPLIT);
        for (String act:acts) {
            //对同一个目标（目标id,目标类型相同）的多个动作感性
            Subscription subscription = new Subscription();
            subscription.setId(GenerateId.INSTANCE.nextId(subscription));
            subscription.setUser(userId);
            subscription.setTarget(target);
            subscription.setTargetType(targetType);
            subscription.setAction(act);
            subscription.setCreateAt(new Date());
            subscriptions.add(subscription);
        }
    }
}
