package com.design.pattern.action.responsibility.my;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public interface MyFilter {
    /**
     * 统一的执行接口
     * @param status
     */
    void doFilter(int status,FilterChain filterChain);
}
