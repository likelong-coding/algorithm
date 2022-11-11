package com.lkl.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author likelong
 * @date 2022/11/11
 */
public class Sub454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        int sum;
        //哈希法
        //两两数组元素之和，key是前两个数组元素之和，value是元素之和出现次数
        //两两数组时间复杂度O(n^2)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                sum = num3 + num4;
                if (map.containsKey(-sum)) {
                    ans += map.get(-sum);
                }
            }
        }

        // 一个数组 和 三个数组 理论上可行但是时间复杂度过高 O(n^3) 超时
        // for (int num1 : nums1) {
        //     map.put(num1, map.getOrDefault(num1, 0) + 1);
        // }

        // for (int num2 : nums2) {
        //     for (int num3 : nums3) {
        //         for (int num4 : nums4) {
        //             sum = num2 + num3 + num4;
        //             if (map.containsKey(-sum)) {
        //                 ans += map.get(-sum);
        //             }
        //         }
        //     }
        // }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.println(new Sub454().fourSumCount(nums1, nums2, nums3, nums4));
    }
}
