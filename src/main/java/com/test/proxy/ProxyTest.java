package com.test.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by huangchangling on 2018/7/27.
 */
public class ProxyTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:/code/classes/cglib");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new UserServiceImplProxy());
        UserServiceImpl userService = ( UserServiceImpl)enhancer.create();
        userService.add();
    }
}
