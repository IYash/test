package com.design.pattern.action.command.marco;

import com.design.pattern.action.command.my.Button;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public interface MacroButton  extends Button {
    /**
     * 宏命令聚集的管理方法
     * 可以添加一个成员命令
     * @param button
     */
    void add(Button button);

    /**
     * 宏命令聚集的管理方法
     * 可以删除一个成员命令
     * @param button
     */
    void remove(Button button);
}
