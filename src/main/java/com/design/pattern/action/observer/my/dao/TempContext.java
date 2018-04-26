package com.design.pattern.action.observer.my.dao;

import com.design.pattern.action.observer.my.entity.Notify;
import com.design.pattern.action.observer.my.entity.Subscription;
import com.design.pattern.action.observer.my.entity.User;
import com.design.pattern.action.observer.my.entity.UserNotify;

import java.util.*;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public class TempContext {

    public Map<Long,User> userMap = new HashMap<>();//模拟用户表

    public Map<Long,Notify> notifyMap = new HashMap<>();//模拟提醒表

    public Map<Long,Subscription> subscriptionMap = new HashMap<>(); //模拟订阅表

    public Map<Long,UserNotify> userNotifyMap = new HashMap<>();//模拟用户通知表

    public void attachUser(User user){userMap.put(user.getId(),user);}
    public void attachNotify(Notify notify){notifyMap.put(notify.getId(),notify);}
    public void attachSubscription(Subscription subscription){subscriptionMap.put(subscription.getId(),subscription);}
    public void attachUserNotify(UserNotify userNotify){userNotifyMap.put(userNotify.getId(),userNotify);}

    public List<Notify> detachNotity(int target) {
        List<Notify> notifies = new ArrayList<>();
        Set<Long> ids = notifyMap.keySet();
        for (Long id:ids) {
         Notify notify = notifyMap.get(id);
         if(notify.getTarget() == target) notifies.add(notify);
        }
        return notifies;
    }
}
