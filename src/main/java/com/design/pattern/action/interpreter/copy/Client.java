package com.design.pattern.action.interpreter.copy;

/**
 * @author huangchangling on 2017/11/6 0006
 * 客户端类
 */
public class Client {

    public static void main(String[] args) {
        Context ctx = new Context();
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Constant c = new Constant(true);
        ctx.assign(x,false);
        ctx.assign(y,true);

        Expression exp = new Or(new And(c,x),new And(y,new Not(x)));
        System.out.println("x=" + x.interpret(ctx));
        System.out.println("y=" + y.interpret(ctx));
        System.out.println(exp.toString() + "=" + exp.interpret(ctx));
    }
}
