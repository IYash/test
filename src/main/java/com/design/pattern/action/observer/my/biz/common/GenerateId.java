package com.design.pattern.action.observer.my.biz.common;

import com.design.pattern.action.observer.my.entity.*;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public enum GenerateId {
    INSTANCE;//通过枚举实现单例

    private volatile long userId = 0;
    private volatile long notifyId = 0;
    private volatile long userNotifyId =0;
    private volatile long suscriptionId =0;

    private GenerateId(){}
    private void setUserId(long userId) {
        this.userId = userId;
    }

    private void setNotifyId(long notifyId) {
        this.notifyId = notifyId;
    }

    private void setUserNotifyId(long userNotifyId) {
        this.userNotifyId = userNotifyId;
    }

    private void setSuscriptionId(long suscriptionId) {
        this.suscriptionId = suscriptionId;
    }

    public long nextUserId(){
        setUserId(++userId);
        return userId;
    }
    public long nextNotifyId(){
        setNotifyId(++notifyId);
        return notifyId;
    }
    public long nextUserNotifyId(){
        setUserNotifyId(++userNotifyId);
        return userNotifyId;
    }
    public long nextSubscriptionId(){
        setSuscriptionId(++suscriptionId);
        return suscriptionId;
    }

    public <T>long nextId(T target){
       if(target instanceof User) return nextUserId();else if(target instanceof Notify) return nextNotifyId();
        else if(target instanceof UserNotify) return nextUserNotifyId();else if(target instanceof Subscription) return nextSubscriptionId();
        else{
           return 0;
       }
    }

}
