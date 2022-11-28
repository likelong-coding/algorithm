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
        return ans;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1};
        System.out.println(Arrays.toString(topKFrequent(nums, 1)));
    }
}
