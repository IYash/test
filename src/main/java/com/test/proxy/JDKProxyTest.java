package com.test.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by huangchangling on 2018/11/21.
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        IUserService userService = (IUserService) Proxy.newProxyInstance(
          IUserService.class.getClassLoader(),new Class[]{IUserService.class},
                new UserServiceInvocation()
        );
        userService.delete();
    }
}
