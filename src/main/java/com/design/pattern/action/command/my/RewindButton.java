package com.design.pattern.action.command.my;

/**
 * @author huangchangling on 2017/11/3 0003
 * 倒带
 */
public class RewindButton extends BaseButton{


    public RewindButton(MyAudioPlayer myAudioPlayer) {
        super(myAudioPlayer);
    }

    @Override
    public void execute() {
        myAudioPlayer.rewind();
    }
}
