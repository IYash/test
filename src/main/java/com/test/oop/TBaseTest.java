package com.test.oop;


/**
 * @author huangchangling on 2017/7/3 0003
 */
public class TBaseTest {

    private static String zDescription = "zone";

    private static long zObjectId = 1L;

    private static String pDescription = "plant";

    private static long pObjectId = 2L;

    public static void main(String[] args){

        Base oZone = new Zone(zDescription,zObjectId);

        Base oPlant = new Plant(pDescription,pObjectId);

        //TBase<Zone> zone = new TBase<Zone>((Zone) oZone);

        //TBase<Plant> plant = new TBase<Plant>((Plant)oPlant);

        TBase<Zone> zone = new TBase(oZone);

        TBase<Plant> plant = new TBase(oPlant);

        zone.common();

        plant.common();

    }
}
