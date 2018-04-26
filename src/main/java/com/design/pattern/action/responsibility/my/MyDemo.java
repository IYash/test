package com.design.pattern.action.responsibility.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public class MyDemo {

    public static void main(String[] args) {

        //初始化filter
        MyFilter filter1 = new FirstConcreteFilter();
        MyFilter filter2 = new SecondConcreteFilter();
        List<MyFilter> filters=new ArrayList<>();
        filters.add(filter1);
        filters.add(filter2);
        //初始化FilterGroup
        StaticFilterGroup staticFilterGroup = new StaticFilterGroup();
        staticFilterGroup.setFilters(filters);
        //初始化dispatcher
        Dispatcher dispatcher = new DefaultDispatcher(staticFilterGroup);
        dispatcher.dispatch(1);

    }
}
