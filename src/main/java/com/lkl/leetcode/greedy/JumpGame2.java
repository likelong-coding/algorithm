package com.lkl.leetcode.greedy;

/**
 * 45. 跳跃游戏 II
 *
 * @author likelong
 * @date 2023/1/9
 */
public class JumpGame2 {

    public int jump(int[] nums) {

        /*
        在当前可跳跃范围内，找到最大的跳跃范围，达到当前跳跃范围边界，替换跳跃范围【找到的最大的跳跃范围替换当前可跳跃范围】，
        跳跃次数 + 1，直到超过最后一个元素的下标
         */

        // 跳跃次数
        int jump = 0;

        // 只有一个元素不需要跳跃
        if (nums.length == 1) {
            return jump;
        }

        // 当前能跳跃的距离
        int curJumpDistance = 0;
        // 在当前跳跃范围内找到最大的跳跃范围
        int maxJumpDistance = 0;

        for (int i = 0; i < nums.length; i++) {
            // 当前跳跃范围内找到最大的跳跃范围
            maxJumpDistance = Math.max(maxJumpDistance, i + nums[i]);

            // 达到当前跳跃范围边界
            if (i == curJumpDistance) {
                jump++;
                curJumpDistance = maxJumpDistance;

                if(curJumpDistance >= nums.length - 1){
                    break;
                }
            }
        }
        return jump;
    }
}
