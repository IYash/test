package com.it.learn.to8;

import static org.junit.Assert.*;

import com.test.lambda.stream.Widget;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huangchangling on 2017/7/6 0006
 */
public class LambdaTest {


    @Test
    public void testWidget(){
        List<Widget> widgets = getWidgets();

        //通过stream计算红色占的比重
        int weights = widgets.stream().filter(widget -> widget.getColor().equals("red"))
                .mapToInt(widget -> widget.getWeight()).sum();
        System.out.println(weights);
        //传统的写法，其实差异在于参数识别以及方法重写
        /*widgets.stream().map(new Function<Widget, Integer>() {

            @Override
            public Integer apply(Widget widget) {
                return widget.getWeight();
            }
        });*/
        long count =  widgets.stream().flatMap(widget -> widget.getGoods().stream()).filter(widget -> widget.contains("e")).count();
        System.out.println(count);

        Stream.of("one","two","three","four").filter(e -> e.length() > 3).peek(e -> System.out.println("element value is "+e))
                .map(String::toUpperCase).peek(e -> System.out.println("ELEMENT VALUE IS "+e)).collect(Collectors.toList());

        int ret = widgets.stream().mapToInt(widget -> widget.getWeight()).reduce(0,(a,b) -> a+b);
        System.out.println(ret);
        double averWeight = widgets.stream().collect(Collectors.averagingInt(widget -> widget.getWeight()));
        System.out.println(averWeight);

        StringBuilder reduced =
                widgets.stream()
                        .map(Widget::getColor)
                        .reduce(new StringBuilder(), (builder, name) -> {
                            if (builder.length() > 0)
                                builder.append(", ");
                            builder.append(name);
                            return builder;
                        }, (left, right) -> left.append(right));//U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner
        reduced.insert(0, "[");
        reduced.append("]");
        String result = reduced.toString();
        System.out.println(result);

    }

    private List<Widget> getWidgets() {
        Widget wr = new Widget("red",10);
        wr.getGoods().add("red");
        wr.getGoods().add("redd");
        Widget wr1 = new Widget("red",13);
        wr1.getGoods().add("red1");
        wr1.getGoods().add("redd1");
        Widget wg = new Widget("green",11);
        wg.getGoods().add("green");
        wg.getGoods().add("greenn");
        Widget wy = new Widget("yellow",12);
        wy.getGoods().add("yellow");
        wy.getGoods().add("yelloww");

        List<Widget> widgets = new ArrayList<>();
        widgets.add(wr);
        widgets.add(wr1);
        widgets.add(wg);
        widgets.add(wy);
        return widgets;
    }

    @Test
    public void testLambda(){
        //reduce模式的使用，从一组数据中得到一个数据
        int count = Stream.of(1,2,3,4).reduce(1,(acc,element) -> acc+element);
        assertEquals(11,count);
    }

}
