package com.design.pattern.action.observer.my.biz;

import com.design.pattern.action.observer.my.entity.Subject;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public interface Observer<T extends Subject> {

    public void update(T t);

    public Class<T> getType();

}
