package com.design.pattern.action.responsibility.my;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public class SecondConcreteFilter implements MyFilter {

    @Override
    public void doFilter(int status,FilterChain filterChain) {
        System.out.println(status);
        filterChain.doFilter(status++,filterChain);
    }
}
