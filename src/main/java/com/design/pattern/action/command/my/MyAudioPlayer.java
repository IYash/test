package com.design.pattern.action.command.my;

/**
 * @author huangchangling on 2017/11/3 0003
 * 接收者角色,真正的执行对象
 */
public class MyAudioPlayer {

    public void play(){
        System.out.println("========play=======");
    }
    public void rewind(){
        System.out.println("========rewind=======");
    }
    public void stop(){
        System.out.println("========stop=======");
    }

}
