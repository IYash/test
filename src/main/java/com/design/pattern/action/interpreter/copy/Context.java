package com.design.pattern.action.interpreter.copy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchangling on 2017/11/6 0006
 * 环境Context蒂尼出从变量到布尔值的一个映射
 */
public class Context {

    private Map<Variable,Boolean> map = new HashMap<>();

    public void assign(Variable var,boolean value){
        map.put(var,new Boolean(value));
    }

    public boolean lookup(Variable var) throws IllegalArgumentException{
        Boolean value  = map.get(var);

        if(value == null){
            throw  new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}
