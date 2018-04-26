package com.test.lambda.stream;

import java.util.Date;

/**
 * @author huangchangling on 2017/7/11 0011
 */
public class Employee {
    private String empName;
    private Department department;
    private double salary;
    private String role = "common";//master,common

    public Employee(String empName, Department department, double salary) {
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
