package com.test.oop;

/**
 * @author huangchangling on 2017/7/3 0003
 */
public class ZoneTest {

    public static void main(String[] args) {

        String description = "zone";

        long objectId = 1L;

        String longitude = "108.6E";

        String lattitude = "26.7N";

        Base zone = new Zone(description,objectId,longitude,lattitude);

        //成员接口测试
        zone.individual(description,objectId);

        //静态接口测试
        zone.timeInfo();

    }
}
