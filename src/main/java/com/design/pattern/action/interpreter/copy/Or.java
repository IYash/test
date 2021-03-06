package com.design.pattern.action.interpreter.copy;

/**
 * @author huangchangling on 2017/11/6 0006
 * 代表逻辑“或”操作的Or类，表示由两个布尔表达式通过逻辑“或”操作给出一个新的布尔表达式的操作
 */
public class Or extends Expression {
    private Expression left,right;

    public Or(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Context ctx) {
        return left.interpret(ctx) || right.interpret(ctx);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Or){
            return left.equals(((Or) obj).left) && right.equals(((Or) obj).right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return "("+left.toString()+"OR"+right.toString()+")";
    }
}
