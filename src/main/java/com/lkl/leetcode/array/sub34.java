package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/10/20
 */
public class sub34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }

        int index = binarySearch(nums, target);
        //不存在
        if (index == -1) {
            return new int[]{-1, -1};
        }

        int left = index;
        int right = index;
        //继续向左找 注意左右临界值 防止数组越界
        while (left > 0 && nums[left - 1] == target) {
            left--;
        }
        //向右找
        while (right < (nums.length - 1) && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};

    }

    /**
     * 二分查找
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 中间元素索引
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 不存在
        return -1;
    }
}
