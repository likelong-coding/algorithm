package com.lkl.leetcode.greedy;

/**
 * 53. 最大子数组和
 *
 * @author likelong
 * @date 2023/1/8
 */
public class LC53 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        // 重新计算即将连续和赋值为0，重新计算连续和
        // 局部最优：当`连续和`为负数时从下一个元素开始【重新计算】`连续和`，否则继续累加得到`连续和`
        // 全局最优：取最大`连续和`
        for (int num : nums) {
            sum += num;
            // max 找到最大的连续和
            max = Math.max(sum, max);

            // 当连续和小于 0 时，重新开始计算连续和，因为负的连续和只会让连续和变小
            if (sum < 0) {
                // 相当于调整连续数组位置
                sum = 0;
            }
        }

        return max;
    }
}
