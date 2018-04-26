package com.test.lambda.design;

/**
 * @author huangchangling on 2017/7/24 0024
 */
public class Open implements Action {

    private final Editor editor;

    public Open(Editor editor){
        this.editor = editor;
    }
    @Override
    public void perform() {
        editor.open();
    }
}
