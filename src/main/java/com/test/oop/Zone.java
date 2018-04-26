package com.test.oop;




import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huangchangling on 2017/7/3 0003
 *
 * @decription 描述区域信息
 */
public class Zone extends Base{

    //经度
    private String longitude;

    //纬度
    private String lattitude;

    private static DateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");

    public Zone(){}

    public Zone(String description,long objectId){
        super(description,objectId);
    }

    public Zone(String description, long objectId, String longitude,String lattitude){

        super(description,0);

        //重定义objectId
        this.objectId = objectId;

        this.longitude = longitude;

        this.lattitude = lattitude;
    }

    //覆盖私有方法--->私有方法不能覆盖
    //覆盖protected,子类的访问权限要高于/等价于父类
    @Override
    public void individual(String description,long objectId){

        super.individual(description,objectId);//不是设计成递归时不要忽略super

        System.out.println("Zone is response for individual");
    }

    @Override
    public void common(String description,long objectId){

        super.common(description,objectId);

        System.out.println("Zone is response for common");
    }
    //方法重载
    private void individual(String longitude,String lattitude){

        System.out.println("Zone is response for individual:"+this.longitude+"==========="+ this.lattitude);
    }

    //静态接口--->静态接口不能覆盖
    public static void timeInfo(){
        System.out.println(sdf.format(new Date()));
    }
    //抛出类型验证--->抛出更普通的异常
    @Override
    public void notFind() throws RuntimeException{
        System.out.println("Zone throws exception");
    }
}
