package com.design.pattern.action.responsibility.my;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public interface FilterChain {

    public void doFilter(int status,FilterChain filterChain);
}
