package com.test.oop;

/**
 * @author huangchangling on 2017/7/3 0003
 */
public class Plant extends Base{

    private String color;

    public Plant(){}

    public Plant(String description, long objectId){

        super(description,objectId);
    }

    public Plant(String description, long objectId, String color){

        super(description,objectId);

        this.color = color;
    }

    @Override
    public void common(String description, long objectId){

        super.common(description,objectId);

        System.out.println("Plant is response for common");
    }
}
