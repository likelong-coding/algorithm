package com.lkl.leetcode.greedy;

/**
 * 55. 跳跃游戏
 *
 * @author likelong
 * @date 2023/1/9
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        // 初始能覆盖的最大范围
        int cover = 0;

        // 在能覆盖的范围内找到更大的覆盖范围并替换，
        // 判断覆盖范围是否大于最后一个元素下标
        for (int i = 0; i <= cover; i++) {
            // 找到覆盖范围内，最大的覆盖范围
            cover = Math.max(i + nums[i], cover);

            // 只要覆盖范围大于最后一个元素下标，直接返回true
            // 说明覆盖到终点了
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        // 否则没法到达最后一个元素，返回false
        return false;
    }
}
