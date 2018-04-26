package com.it.learn;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author huangchangling on 2017/6/27 0027
 */
public class PThreadLocal {

    private static AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
    protected Integer initialValue(){
        return nextId.getAndIncrement();
    }
};

    private static final ThreadLocal<String> perfomance = new ThreadLocal<String>(){
        @Override protected String initialValue(){
            return  String.valueOf(nextId+"==========perform==========");
        }
    };
    public static Integer getInteger(){
        return threadId.get();
    }
    public static String getString(){
        return perfomance.get();
    }
    @Test
    public void testThreadLocal(){
        Integer ret = PThreadLocal.getInteger();
        threadId.set(3);//在当前线程中是可以修改的
        System.out.println(PThreadLocal.getInteger());
        //threadId.remove();//用于测试initialValue的执行机制
        String rett = PThreadLocal.getString();
        //Integer ret2 = PThreadLocal.getInteger();
        System.out.println(ret+"++++++++++++"+rett);
        //传统的匿名对象的写法
        ThreadLocal<String> sdf = ThreadLocal.withInitial(new Supplier<String>() {
            @Override
            public String get() {
                return new SimpleDateFormat("MM-dd-yy").format(new Date());
            }
        });
        System.out.println(sdf.get());

        //lamba表达法
        ThreadLocal<String> lsdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("MM-dd-yy").format(new Date()));
        System.out.println(lsdf.get());

        Runnable run = () -> System.out.println("hello");
        run.run();

        List<String> rs = new ArrayList<String>();
        rs.add("a");rs.add("bba");rs.add("c");
        Stream<String> rr = rs.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("a");
            }
        });
        rs.stream().filter(s -> s.contains("a")).count();
        System.out.println(rr.count());
     }
}
