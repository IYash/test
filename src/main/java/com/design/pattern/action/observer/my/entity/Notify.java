package com.design.pattern.action.observer.my.entity;

import java.util.Date;

/**
 * @author huangchangling on 2017/11/10 0010
 * 例如:小明喜欢了文章,可以表示为
 * target = 123 //文章id
 * targetType = 'post'//文章
 * sender =123456  //小明id
 * action = 'LIKE' //动作类型
 * type = 'notify' //提醒
 */
public class Notify extends Subject {


    private String content;
    private String type;//消息类型
    private int target;//目标id
    private String targetType;//目标类型
    private String action;//提醒消息的动作类型
    private long sender;//发送者id




    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public long getSender() {
        return sender;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Notify{" +
                "content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", target=" + target +
                ", targetType='" + targetType + '\'' +
                ", action='" + action + '\'' +
                ", sender=" + sender +
                '}';
    }
}
