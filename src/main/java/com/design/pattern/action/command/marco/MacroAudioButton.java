package com.design.pattern.action.command.marco;

import com.design.pattern.action.command.my.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public class MacroAudioButton implements MacroButton {

    private List<Button> buttonList = new ArrayList<>();

    @Override
    public void add(Button button) {
        buttonList.add(button);
    }

    @Override
    public void remove(Button button) {
        buttonList.remove(button);
    }

    @Override
    public void execute() {
        buttonList.stream().forEach(button -> button.execute());
    }
}
