package com.test.proxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by huangchangling on 2018/7/27.
 */
public class UserServiceImplProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before:"+method.getName());
        methodProxy.invokeSuper(o,objects);
        System.out.println("after:"+method.getName());
        return null;
    }
}
