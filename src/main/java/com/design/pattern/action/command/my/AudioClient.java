package com.design.pattern.action.command.my;

import java.lang.reflect.Method;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public class AudioClient {

    public static void main(String[] args) throws Exception {

        MyAudioPlayer audioPlayer = new MyAudioPlayer();

        KeyPad keyPad = new KeyPad();

        PlayButton play = new PlayButton(audioPlayer);

        keyPad.setPlayButton(play);

        keyPad.actionPlay();

        Method method = Button.class.getMethod("execute");

        ActionUtil.action(play,method);
        //这种方式比较友善，客户端做最少的事情
        ActionUtil.action(play,null);

        BaseButton baseButton = new StopButton(audioPlayer);
        baseButton.action();
    }
}
