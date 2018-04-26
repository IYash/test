package com.fun.vo;

/**
 * @author huangchangling on 2017/9/13 0013
 */
public class Employee {

    public boolean equals(Object rhs){
        return rhs instanceof Employee && name.equals(((Employee)rhs).getName());
    }
    public int hashCode(){
        return name.hashCode();
    }
    private String name;
    private double salary;
    private int seniority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }
}
