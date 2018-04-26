package com.test.rop;

import com.rop.AbstractRopRequest;

/**
 * @author huangchangling on 2017/6/13 0013
 */
public class LogonRequest extends AbstractRopRequest{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
