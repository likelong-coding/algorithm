package com.lkl.leetcode.stackAndQueue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author likelong
 * @date 2022/11/30
 */
public class Sub239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] ans = new int[len];
        //一、大顶堆
//        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 -num1);
//        for(int i = 0; i < len; i++){
//            queue.clear();
//            int temp = i;
//            while(temp < i + k){
//                queue.add(nums[temp++]);
//                ans[i] = queue.peek();
//            }
//        }


        //二、快排
//        int[] tempArr = new int[k];
//        for(int i = 0; i < len; i++){
//
//            int m = 0;
//            for (int j = i; j < i + k; j++){
//                tempArr[m++] = nums[j];
//            }
//            Arrays.sort(tempArr);
//            ans[i] = tempArr[k - 1];
//        }

        //三、自定义单调栈：单调队列只维护可能是最大值的数
//        MyQueue queue = new MyQueue();
//        int index = 0;
//        //先push前k个元素
//        for (int i = 0; i < k; i++) {
//            queue.push(nums[i]);
//        }
//        ans[index++] = queue.getMax();
//
//        for (int i = k; i < nums.length; i++) {
//            //弹出最开始的元素
//            queue.pop(nums[i - k]);
//            queue.push(nums[i]);
//            ans[index++] = queue.getMax();
//        }

        //直接使用双端队列实现单调栈
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //先pop 弹出开始元素
            if (!deque.isEmpty() && i - k >= 0 && nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }

            //再push
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.add(nums[i]);
            //最后取出最大元素[队头元素]，从前k个元素开始
            if (i >= k - 1) {
                ans[index++] = deque.peekFirst();
            }
        }
        return ans;
    }


    /**
     * 自定义单调队列
     * 队列中元素从头到尾依次递减，
     * pop元素时，开始元素与队头元素相等时，pop出队头元素
     * push元素时，队尾元素比当前元素小将该元素弹出（因此需要双端队列）
     * 每次pop、push结束之后，获取队列中最大值（即队头元素）getMax
     */
    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        void pop(int val) {
            //只有开始值与队头元素相等，才将队头元素弹出
            if (!deque.isEmpty() && deque.getFirst() == val) {
                deque.removeFirst();
            }
        }

        void push(Integer val) {
            //队尾值比当前元素小的话，直接从队尾弹出
            while (!deque.isEmpty() && deque.getLast() < val) {
                deque.removeLast();
            }

            deque.addLast(val);
        }

        //返回队头最大值
        public int getMax() {
            return deque.peek();
        }

    }

    @Test
    public void test() {
        int[] nums = new int[]{1};

        System.out.println(Arrays.toString(maxSlidingWindow(nums, 1)));
    }
}
