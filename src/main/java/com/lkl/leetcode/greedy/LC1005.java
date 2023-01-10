package com.lkl.leetcode.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 1005.K次取反后最大化的数组和
 * @author likelong
 * @date 2023/1/10
 */
public class LC1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        // 直接排序
        Arrays.sort(nums);
        // 记录绝对值最小元素
        int minAbs = 101;

        for (int i = 0; i < nums.length; i++) {
            // 从前往后，优先将绝对值较大的负数反转
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                // 反转一个 k--
                k--;
            }

            minAbs = Math.min(minAbs, nums[i]);
            sum += nums[i];

        }

        // k 还有剩余（说明负数全部取反）并且为奇数，将绝对值最小值取反即可，由于已经提前加过一次 minAbs
        // 所以 要减 两个minAbs
        if (k % 2 == 1) {
            sum -= 2 * minAbs;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 1));
    }
}
