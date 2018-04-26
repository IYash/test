package com.design.pattern.action.command.my;

/**
 * @author huangchangling on 2017/11/3 0003
 * 播放
 */
 @MyMethod("execute")
public class PlayButton extends BaseButton{

    public PlayButton(MyAudioPlayer myAudioPlayer) {
        super(myAudioPlayer);
    }

    @Override
    public void execute() {
        myAudioPlayer.play();
    }

}
