package com.lkl.leetcode.stackAndQueue;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 */
class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        //顺序存放元素
        stack1 = new Stack<>();

        //逆序存放元素
        stack2 = new Stack<>();
        //两个栈同时只能一个栈存放元素，要么顺序存放，要么逆序存放
    }

    public void push(int x) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.size() == 0 && stack2.size() == 0;
    }
}
