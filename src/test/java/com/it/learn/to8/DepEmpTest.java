package com.it.learn.to8;

import com.test.lambda.stream.Department;
import com.test.lambda.stream.Employee;
import org.junit.Test;

import java.util.*;
import static java.util.stream.Collectors.*;


/**
 * @author huangchangling on 2017/7/11 0011
 */
public class DepEmpTest {

    @Test
    public void testDepEmp(){
        //departments
        Department function = new Department("function");
        Department operation = new Department("operation");
        Department develop = new Department("develop");
        List<Department> depts = new ArrayList<>();
        depts.add(function);depts.add(operation);depts.add(develop);

        //employees
        Employee e1 = new Employee("zhaoyi",function,8000);
        Employee e2 = new Employee("qianer",operation,7000);
        Employee e3 = new Employee("sunsan",operation,9000);
        Employee e4 = new Employee("lisi",operation,10000);
        e4.setRole("master");
        Employee e5 = new Employee("zhouwu",develop,8000);
        Employee e6 = new Employee("wuliu",develop,9000);
        Employee e7 = new Employee("zhengqi",develop,10000);
        e7.setRole("master");
        Employee e8 = new Employee("wangba",develop,6000);
        Employee e9 = new Employee("moumou",develop,7000);

        List<Employee> emps = new ArrayList<>();
        emps.add(e1);emps.add(e2); emps.add(e3); emps.add(e4); emps.add(e5); emps.add(e6); emps.add(e7); emps.add(e8); emps.add(e9);

        //列出function的所有员工
        List<Employee> fEmps = emps.stream().filter(emp ->
        function.getDepName().equals(emp.getDepartment().getDepName())
            ).collect(toList());
        for (Employee emp:fEmps
             ) {
            System.out.println(emp.getEmpName());
        }

        //将所有员工按部门分组
        //Map<Department,List<Employee>> dept2Emps = emps.stream().collect(groupingBy(emp -> emp.getDepartment(),toList()));
       Map<Department,List<Employee>> d2emps = emps.stream().collect(groupingBy(emp -> emp.getDepartment()));
        Set<Department> deptKeys = d2emps.keySet();
        for (Department dept:deptKeys
             ) {
            System.out.println(dept.getDepName()+"----->size: "+d2emps.get(dept).size());
        }

        Map<Department,Long> d2count = emps.stream().collect(groupingBy(emp -> emp.getDepartment(),counting()));
        //列出薪资最高的员工所在的部门



        //统计各部门的薪资支出



    }
}
