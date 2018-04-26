package com.design.pattern.action.command.copy;

/**
 * @author huangchangling on 2017/11/3 0003
 * 请求者角色类
 */
public class Invoker {

    /**
     * 命令持有者对象
     */
    private Command command = null;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 行动方法
     */
    public void action(){
        command.execute();
    }
}
