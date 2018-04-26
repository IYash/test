package com.test.generic;

/**
 * @author huangchangling on 2017/9/4 0004
 */
class Employee extends People {
    private String ename;
    private int eage;
    public static String canSee = "see";
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getEage() {
        return eage;
    }

    public void setEage(int eage) {
        this.eage = eage;
    }
}
