package com.design.pattern.action.responsibility.my;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public class DefaultDispatcher implements Dispatcher{

    private FilterGroup filterGroup;

    public DefaultDispatcher(FilterGroup filterGroup){
        this.filterGroup = filterGroup;
    }

    public void dispatch(int status){
        filterGroup.doFilter(status);
    }

}
