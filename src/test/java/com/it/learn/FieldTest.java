package com.it.learn;

import org.junit.Test;

/**
 * @author huangchangling on 2017/7/25 0025
 */
class Base{
    private String symbol = "symbol";

    public Base(){
        System.out.println("super" + symbol);
    }

    public Base(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
class Other{

    {
        System.out.println("hello world");
    }

    public Other(){
        System.out.println("other");
    }

}

/**
 * 验证对象实例化的过程
 */
public class FieldTest extends Base{

    private Other other = new Other();

    public FieldTest(){
        System.out.println("sub");
    }

    @Test
    public void testInit(){

        Base sub = new FieldTest();

    }

    public static void main(String[] args) {
        Base sub = new FieldTest();
    }
}
