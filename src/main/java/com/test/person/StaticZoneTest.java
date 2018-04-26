package com.test.person;

/**
 * @author huangchangling on 2018/1/31 0031
 */
class Super{
    public final static int m;
    static{
        m=10;
        System.out.println("======super========"+m);
    }
}
class Father extends Super{
    public static int m=11;
    static{
        System.out.println("======father========"+m);
    }
}
class Child extends Father{

    static {
        System.out.println("======child========");
    }
}
public class StaticZoneTest {

    public static void main(String[] args) {
        System.out.println(Child.m);
    }
}
