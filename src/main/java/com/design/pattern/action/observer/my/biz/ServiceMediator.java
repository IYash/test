package com.design.pattern.action.observer.my.biz;

import com.design.pattern.action.observer.my.service.NotifyService;

/**
 * @author huangchangling on 2017/11/10 0010
 *
 */

public class ServiceMediator {

    public static NotifyService notifyService;

    static{
        notifyService = new NotifyService();
    }
}
