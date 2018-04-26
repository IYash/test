package com.design.pattern.action.command.my;

/**
 * @author huangchangling on 2017/11/3 0003
 * 停止
 */
public class StopButton extends BaseButton{

    public StopButton(MyAudioPlayer myAudioPlayer) {
        super(myAudioPlayer);
    }

    @Override
    public void execute() {
        myAudioPlayer.stop();
    }
}
