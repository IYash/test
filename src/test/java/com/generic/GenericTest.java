package com.generic;

import com.test.generic.Employee;
import com.test.generic.Generic;
import com.test.generic.People;
import com.test.generic.Student;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author huangchangling on 2017/9/4 0004
 */
public class GenericTest {
    @Test
    /**
     * 数组是协变的意味着People[] arr = new Employee[5]是允许的,编译通过，运行时抛出ArrayStoreException
     * 集合不是协变的， List<People> ls = new ArrayList<Employee>(); 编译时报错
     */
    public void testArray(){
        People[] arr = new Employee[2];
        arr[0] = new Student();
        arr[1] = new Employee();
    }
    /**
     * 泛型测试,运行时抛出ClassCastException
     */
    @Test
    public void testGeneric(){
        Generic<People> gc = new Generic<People>();
        gc.write(new Employee());
        Object go = gc;
        Generic<Student> gc1 = (Generic<Student>) go;
        Student s = gc1.read();
    }
    /**
     * 泛型数组测试，运行时抛出ClassCastException
     */
    @Test
    public void testGenericArray(){
        Generic<Employee>[] gps = new Generic[2];
        Generic<People> g1 = new Generic<>();
        g1.write(new Student());
        Object[] gos = gps;
        gos[0] = g1;
        Employee s=gps[0].read();
    }

    @Test
    public void testConvert(){
        System.out.println(convertPriceToYuan(16812l));
        long l =202l;
        double dd = l*0.98;
        System.out.println(l*0.98);
        System.out.println(dd);
        System.out.println(Double.valueOf(l*0.98));
        Double d = Double.parseDouble(new DecimalFormat("#.##").format(168.99));
        System.out.println(d);
        System.out.println(d.longValue());
    }
    private Long convertPriceToYuan(Long price) {
        if (price == null) {
            return price;
        }
        BigDecimal p = new BigDecimal(price);
        return p.divide(new BigDecimal(100), 0, BigDecimal.ROUND_UP).longValue();
    }
    @Test
    public void testMobile(){
        String mobile ="+8613753142162";
        String mobile1 ="+8613754837727";
        System.out.println(" +8613753142162".trim());
        System.out.println(isMobile(mobile));
        System.out.println(isMobile(mobile1));
    }
    private boolean isMobile(String mobile) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^((\\+86)|(86))?[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(mobile);
        b = m.matches();
        return b;
    }
}
