package com.lkl.leetcode.stackAndQueue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author likelong
 * @date 2022/11/27
 */
public class MyStack2 {
    /**
     * 使用两个队列来实现栈
     */
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        //queue1只维护一个栈顶元素
        int size = queue1.size();

        //size >= 1
        while (size > 1) {
            queue2.offer(queue1.poll());
            size--;
        }

        if (size == 1) {
            return queue1.poll();
        }

        // size = 0
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
            size++;
        }

        while (size > 1) {
            queue2.offer(queue1.poll());
            size--;
        }
        return queue1.poll();
    }

    public int top() {
        //queue1只维护一个栈顶元素
        int size = queue1.size();

        while (size > 1) {
            queue2.offer(queue1.poll());
            size--;
        }

        if (size == 1) {
            return queue1.peek();
        }

        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
            size++;
        }

        while (size > 1) {
            queue2.offer(queue1.poll());
            size--;
        }
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    @Test
    public void test() {
        Queue<Integer> queue = new ArrayBlockingQueue<>(3);

        /*
          add() 添加元素时，当超过初始化容量时，会抛异常 java.lang.IllegalStateException: Queue full
          offer() 添加元素时，当超过初始化容量，不会抛异常，仅不会添加成功返回false
         */
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(1));

        System.out.println(queue.size());
    }
}
