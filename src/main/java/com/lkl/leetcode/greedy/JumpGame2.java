package com.lkl.leetcode.greedy;

/**
 * 45. 跳跃游戏 II
 *
 * @author likelong
 * @date 2023/1/9
 */
public class JumpGame2 {

    public int jump(int[] nums) {

        // 能覆盖的范围
        int cover = 0;
        // 跳跃次数
        int jump = 0;

        // 只有一个元素不需要跳跃
        if (nums.length == 1) {
            return jump;
        }

        for (int i = 0; i <= cover; i++) {
            // 找到覆盖范围内，更大的覆盖范围
            if (cover < (i + nums[i])) {
                cover = i + nums[i];
                // 覆盖范围更大了，此时跳跃次数 + 1
                jump++;
            }

            // 只要能覆盖到最后一个元素下标，直接返回既最小跳跃次数
            if (cover >= nums.length - 1) {
                return jump;
            }
        }

        return jump;
    }
}
