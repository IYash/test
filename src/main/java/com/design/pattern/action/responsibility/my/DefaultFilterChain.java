package com.design.pattern.action.responsibility.my;

import java.util.List;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public class DefaultFilterChain implements FilterChain{

    private List<MyFilter> filters;

    private int pos=0;

    public DefaultFilterChain(List<MyFilter> filters){
        this.filters =filters;

    }

    @Override
    public void doFilter(int status,FilterChain filterChain) {
    if(filters != null)
        if(pos < filters.size())
            filters.get(pos++).doFilter(status,this);
    }
}
