package com.design.pattern.action.responsibility.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public class StaticFilterGroup extends FilterGroup {

    List<MyFilter> filters = new ArrayList<>();


    @Override
    public List<MyFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<MyFilter> filters){
        this.filters = filters;
    }
}
