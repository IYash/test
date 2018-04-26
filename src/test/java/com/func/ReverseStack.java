package com.func;

import org.junit.Test;

import java.util.Stack;

/**
 * @author huangchangling on 2017/9/1 0001
 */
public class ReverseStack {

    /**
     * 假设入栈输入为1,2,3,4,5---->输出为1,2,3,4,5,使用递归实现
     * 1.获取当前栈中下面一个element getAndRemoveLastElement
     * 2.reverseStack
     */
    @Test
    public void testReverStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
       while(!stack.isEmpty()){
           System.out.println(stack.pop());
       }
    }
    int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.peek();
        stack.pop();
        if (stack.isEmpty()) return result;
        else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return ;
        int last = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(last);
    }
}
