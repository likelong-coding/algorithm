package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/10/22
 */
public class sub26 {
    public int removeDuplicates(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            //防止数组越界 多个元素相等将最后一个元素放入数组，不相等直接放入数组
            if ((i < nums.length - 1) && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[j++] = nums[i];
        }

        return j;
    }
}
