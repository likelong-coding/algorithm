package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/10/20
 */
public class Sub27 {

    public int removeElement(int[] nums, int val) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //不满足元素跳过
            if (nums[i] == val) {
                continue;
            }
            //跟目标元素不相等，放入数组中，下标从0开始
            nums[j++] = nums[i];
        }

        return j;
    }
}
