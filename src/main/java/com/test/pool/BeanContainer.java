package com.test.pool;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author huangchangling on 2017/12/14 0014
 */
public class BeanContainer {


    private volatile static BeanContainer instance;

    public static BeanContainer getInstance(){
        if(instance == null){
            synchronized (BeanContainer.class){
                if(instance == null){
                    instance = new BeanContainer();
                }
            }
        }
        return instance;
    }
    public ConcurrentHashMap<String,BasicDataSource> singletonMap = new ConcurrentHashMap<>();

    private BeanContainer(){

        BasicDataSource routePriceDataSource = createDateSource("com.mysql.jdbc.Driver","jdbc:mysql://10.113.1.9:3306/test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true","root","123456");

        singletonMap.put("test",routePriceDataSource);
    }

    private BasicDataSource createDateSource(String driverClassName, String url, String userName, String password) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(7);
        dataSource.setMaxWait(100);
        dataSource.setTimeBetweenEvictionRunsMillis(30000);
        dataSource.setMinEvictableIdleTimeMillis(30000);
        dataSource.setRemoveAbandoned(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setValidationQuery("SELECT 1");
        return dataSource;
    }
}
