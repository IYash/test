package com.test.lambda.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchangling on 2017/7/24 0024
 *
 * @decription 宏，用于记录action
 */
public class Macro {

    private final List<Action> actions ;

    public Macro(){
        actions = new ArrayList<>();
    }

    public void record(Action action){
        actions.add(action);
    }

    public void run(){
        actions.forEach(Action::perform);
    }
}
