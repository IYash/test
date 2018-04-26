package com.design.pattern.action.command.my;

/**
 * @author huangchangling on 2017/11/3 0003
 * 特别像是一个调度的角色
 */
public abstract class BaseButton implements Button{

    protected MyAudioPlayer myAudioPlayer;

    public BaseButton(MyAudioPlayer myAudioPlayer) {
        this.myAudioPlayer = myAudioPlayer;
    }

    public void action(){
        execute();
    }

}
