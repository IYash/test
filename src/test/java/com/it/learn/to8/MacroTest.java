package com.it.learn.to8;

import com.test.lambda.design.Editor;
import com.test.lambda.design.Macro;

import org.junit.Test;

/**
 * @author huangchangling on 2017/7/24 0024
 */
public class MacroTest {

    @Test
    public void testMarco(){
        Editor editor = new Editor() {
            @Override
            public void save() {
                System.out.println("save");
            }

            @Override
            public void open() {
                System.out.println("open");
            }

            @Override
            public void close() {
                System.out.println("close");
            }
        };
        Macro macro = new Macro();
        macro.record(editor::save);

        macro.record(editor::open);

        macro.record(editor::close);

        macro.run();
    }
}
