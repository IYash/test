package com.design.pattern.action.responsibility.my;

import java.util.List;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public abstract class FilterGroup {

    public abstract List<MyFilter> getFilters();

    public void doFilter(int status){

        new DefaultFilterChain(getFilters()).doFilter(status, new FilterChain() {
            @Override
            public void doFilter(int status, FilterChain filterChain) {
                System.out.println("end====================");
                return ;
            }
        });
    }

}
