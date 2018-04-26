package com.design.pattern.action.command.copy;

/**
 * @author huangchangling on 2017/11/3 0003
 */
public class ConcreteCommand implements Command {

    //持有相应的接收者对象
    private Receiver receiver = null;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //通常会转调接收者对象的对应方法，让接收者来真正执行功能
        receiver.action();
    }
}
