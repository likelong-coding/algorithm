package com.lkl.leetcode.stackAndQueue;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * @author likelong
 * @date 2022/11/28
 */
public class Sub150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        //加法、乘法两个元素先后顺序无所谓，减法、除法两个元素顺序不能被改变
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int first = stack.pop();
                stack.push(stack.pop() / first);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        //到最后栈中只有一个元素，该元素就是最后的结果
        return stack.pop();
    }
}
