package com.test.lambda.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchangling on 2017/7/7 0007
 */
public class Widget {

    private String color;

    private int weight;

    private List<String> goods = new ArrayList<>();

    public Widget(){}

    public Widget(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getGoods() {
        return goods;
    }

    public void setGoods(List<String> goods) {
        this.goods = goods;
    }
}
