package com.it.learn;

/**
 * @author huangchangling on 2017/8/17 0017
 */
public enum Food {
    ORANGE("橘子",2),

    BANANA("香蕉",1);
    private String cname;

    private int num;

    private Food(String cname,int num){
        this.cname = cname;
        this.num = num;
    }

    public  String getCname(){
        return this.cname;
    }

    public int getNum() {
        return num;
    }
}
