package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/10/20
 */
public class Sub704 {

    public int search(int[] nums, int target) {
        //target 小于nums[0] 或 大于nums[nums.length - 1]时 直接返回-1
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0;
        int rigth = nums.length - 1;
        while (left <= rigth) {
            //每一轮数组中中间元素索引如何得到？
            int mid = (rigth + left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                rigth = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //right < left 说明不存在目标元素，直接返回-1
        return -1;
    }
}
