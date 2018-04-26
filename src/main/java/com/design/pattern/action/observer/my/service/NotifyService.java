package com.design.pattern.action.observer.my.service;


import com.design.pattern.action.observer.my.dao.TempContext;
import com.design.pattern.action.observer.my.entity.Notify;
import com.design.pattern.action.observer.my.entity.Subscription;
import com.design.pattern.action.observer.my.entity.User;
import com.design.pattern.action.observer.my.entity.UserNotify;

import java.util.List;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public class NotifyService {

    private static final TempContext CONTEXT = new TempContext();

    /**
     * 用户订阅动作
     * @param subscription
     */
    public void subscribe(Subscription subscription){
        CONTEXT.attachSubscription(subscription);
        System.out.println("----------subscribe subscription------------"+subscription.toString());
    }

    public void createNotify(Notify notify){
        CONTEXT.attachNotify(notify);
        System.out.println("----------create notify------------"+notify.toString());
    }

    public void createUserNotify(UserNotify userNotify){
        CONTEXT.attachUserNotify(userNotify);
        System.out.println("----------create userNotify------------"+userNotify.toString());
    }

    public void createUser(User user){
        CONTEXT.attachUser(user);
        System.out.println("----------create user------------"+user.toString());
    }

    public List<Notify> getNotifiesByTarget(int target){
        List<Notify> notifies = CONTEXT.detachNotity(target);
        for (Notify notify:notifies
             ) {
            System.out.println("----------get NotifiesByTarget------------"+notify.toString());
        }
        return notifies;
    }
}
