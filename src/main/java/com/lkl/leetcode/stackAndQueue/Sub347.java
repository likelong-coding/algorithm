package com.lkl.leetcode.stackAndQueue;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author likelong
 * @date 2022/11/28
 */
public class Sub347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //优先级队列，出现次数按从队头到队尾的顺序是从小到大排，出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair1.getValue() - pair2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(entry);
            } else {
                //队列中只维护k个元素，当当前元素出现个数大于堆顶元素出现个数（小顶堆）时，移除队头元素放入当前元素
                if (entry.getValue() > priorityQueue.peek().getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(entry);
                }
            }
        }

        int index = k - 1;
        while (!priorityQueue.isEmpty()) {
            ans[index--] = priorityQueue.poll().getKey();
        }


        //基于大顶堆实现，从头到尾出现频率依次递减
//        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair2.getValue() - pair1.getValue());
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            priorityQueue.add(entry);
//        }
//
//        //直接取前k个元素即可
//        for (int i = 0; i < k; i++) {
//            ans[i] = priorityQueue.poll().getKey();
//        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
