package com.test.lambda.design;

/**
 * @author huangchangling on 2017/7/24 0024
 */
public class Save implements Action {

    private final Editor editor;

    public Save (Editor editor){
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}
