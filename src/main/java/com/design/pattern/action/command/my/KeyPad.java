package com.design.pattern.action.command.my;


/**
 * @author huangchangling on 2017/11/3 0003
 * 请求者角色,这个对象其实可以不用存在，引入BaseButton
 * 拓展的话只需集成BaseButton即可
 */
public class KeyPad {

    private Button playButton;
    private Button rewindButton;
    private Button stopButton;

    public void setPlayButton(Button playButton) {
        this.playButton = playButton;
    }

    public void setRewindButton(RewindButton rewindButton) {
        this.rewindButton = rewindButton;
    }

    public void setStopButton(StopButton stopButton) {
        this.stopButton = stopButton;
    }

    public void actionPlay(){
        playButton.execute();
    }
    public void actionStop(){
        stopButton.execute();
    }
    public void actionRewind(){
        rewindButton.execute();
    }

}
