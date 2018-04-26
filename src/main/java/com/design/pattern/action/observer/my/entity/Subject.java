package com.design.pattern.action.observer.my.entity;


import java.util.Date;

/**
 * @author huangchangling on 2017/11/10 0010
 *
 */
public abstract class Subject {
    private long id;
    private Date createAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


}
