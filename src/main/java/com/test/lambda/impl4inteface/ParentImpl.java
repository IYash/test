package com.test.lambda.impl4inteface;

import com.test.lambda.interface1.Parent;

/**
 * @author huangchangling on 2017/7/13 0013
 */
public class ParentImpl implements Parent {

    private String body;
    @Override
    public void message(String body) {
        this.body = body;
    }

    @Override
    public String getLastMessage() {
        return body;
    }
}
