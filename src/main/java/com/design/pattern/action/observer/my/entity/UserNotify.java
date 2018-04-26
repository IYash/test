package com.design.pattern.action.observer.my.entity;

/**
 * @author huangchangling on 2017/11/10 0010
 * 提醒的对象，user订阅后，从notify拉取数据生成
 */
public class UserNotify extends Subject{


    private long notify;//关联的notifyid
    private long user;//关联的user
    private boolean isRead;//通知是否已读


    public long getNotify() {
        return notify;
    }

    public void setNotify(long notify) {
        this.notify = notify;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public UserNotify pullRemind(){
        // TODO: 2017/12/11 0011
        return null;
    }
    @Override
    public String toString() {
        return "UserNotify{" +
                "notify=" + notify +
                ", user=" + user +
                ", isRead=" + isRead +
                '}';
    }
}
