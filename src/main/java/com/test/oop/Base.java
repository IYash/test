package com.test.oop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huangchangling on 2017/7/3 0003
 *
 * @Description 基类，本例用于测试继承的特性
 */
public class Base {

    //私有字段
    private String description;

    //可继承字段
    protected long objectId;

    //FINAL静态字段
    protected final static String FINALE_BASE = "FINALBASE";

    //静态字段
    protected static String BASE = "BASE";

    //静态成员
    private static DateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

    public Base(){}

    public Base(String description) {
        this(description,0);
    }

    public Base(long objectId) {
        this(null,objectId);
    }

    public Base(String description, long objectId){
        this.description = description;
        this.objectId = objectId;
    }

    //私有接口
    private void exchange(){
        this.description=null;
        this.objectId=0;
        System.out.println("base is reponse for exchange");
    }

    //可继承接口+接口权限

    protected void individual(String description,long objectId){

        System.out.println("base individual description:"+ description +"++++++++++++objectId:"+ objectId);
    }

    public void common(String description,long objectId){
        System.out.println("base common description:"+ description +"++++++++++++objectId:"+ objectId);
    }

    //静态接口
    public static void timeInfo(){
        System.out.println(sdf.format(new Date()));
    }

    //final接口
    public final void destroy(){
        System.out.println("base is response for destroy");
    }

    //异常抛出
    public void notFind() throws NullPointerException{
        System.out.println("base throws exception");
    }

    public String getDescription() {
        return description;
    }

    public long getObjectId() {
        return objectId;
    }
}
