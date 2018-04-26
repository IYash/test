package com.test.generic;

/**
 * @author huangchangling on 2017/9/4 0004
 */
public class Generic<T extends People> {

    private T val;

    public void write(T t){
        this.val = t;
    }
    public T read(){
        return val;
    }

    /**
     * 在一个泛型类中，static方法和static域不可以引用类的泛型变量，因为在泛型擦除后类型变量就不存在了
     * @param t
     * @param <A>
     * @return
     */
    public static <A>A staticMethod(A t){
        return t;
    }
}
