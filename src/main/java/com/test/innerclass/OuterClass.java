package com.test.innerclass;

/**
 * @author huangchangling on 2017/8/14 0014
 *
 * 内部类可以访问外部类的范围
 */
public class OuterClass {

    private String outer = "outer";

    private static String souter = "souter_hello_world";

    public String getOuter(){
        return outer;
    }
    public static String getSouter(){
        return souter;
    }
    public class InnerClass{

        private String inner = "inner";

        //非静态内部类不能有静态属性,字段

        public void init(String newString){
            inner = newString;
            outer += newString;
        }
    }

    public static class SInnerClass{

        private static String sinner = "sinner";

        private String  nsinner = "nsinner";

        public void init(String newString){
            nsinner = newString;
        }

        public static void sinit(String newString){
            sinner = newString;
        }
    }
    public InnerClass buildInnerClass(){
        new OuterClass.InnerClass();
        new OuterClass.SInnerClass();
        return new InnerClass();
    }
    public static void main(String[] args) {
        new OuterClass.SInnerClass();
        System.out.println("heel");
    }
}
