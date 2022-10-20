package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/10/20
 */
public class sub35 {

    // 升序无重复元素数组 ——> 二分排序解法
    public int searchInsert(int[] nums, int target) {

        if (target < nums[0]) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
