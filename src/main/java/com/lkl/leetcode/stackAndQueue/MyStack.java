package com.lkl.leetcode.stackAndQueue;

import java.util.LinkedList;

class MyStack {

    /**
     * 使用一个队列来实现栈
     */
    LinkedList<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.addFirst(x);
    }

    public int pop() {
        return queue.removeFirst();
    }

    public int top() {
        return queue.getFirst();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
