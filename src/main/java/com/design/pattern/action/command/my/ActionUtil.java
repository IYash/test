package com.design.pattern.action.command.my;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public class ActionUtil {
    public static <T> void action(T target, Method method, Object... args){
        try {
            method.invoke(target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static <T> void action(T target,Object... args){
        Class<?> clz= target.getClass();
        MyMethod anno = target.getClass().getAnnotation(MyMethod.class);
        String value = anno.value();
        try {
            Method method = clz.getMethod(value,null);
            method.invoke(target,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
