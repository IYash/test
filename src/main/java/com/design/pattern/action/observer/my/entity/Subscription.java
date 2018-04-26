package com.design.pattern.action.observer.my.entity;

/**
 * @author huangchangling on 2017/11/10 0010
 *订阅是从Notify表拉取消息到 UserNotify的前提，例如：小明关注了产品A的评论
 * target = 123//产品A的id
 * targetType ='product'
 * action = 'comment'
 * user = 123456//小明的id
 */
public class Subscription extends Subject{

    private int target;//目标id
    private String targetType;//目标类型
    private String action;
    private long user;//用户id



    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "target=" + target +
                ", targetType='" + targetType + '\'' +
                ", action='" + action + '\'' +
                ", user=" + user +
                '}';
    }
}
