package com.lkl.leetcode.random;

import java.util.Arrays;

/**
 * 912. 排序数组
 *
 * @author likelong
 * @date 2023/1/30
 */
public class Sort {

    public int[] sortArray(int[] nums) {
//        bubbleSort(nums);

//        quickSort(nums, 0, nums.length - 1);

        Arrays.sort(nums);
        return nums;
    }

    // 冒泡排序
    public void bubbleSort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    // 快速排序
    public void quickSort(int[] arr, int l, int r) {
        // 递归终止条件
        if (l >= r) {
            return;
        }

        int left = l;
        int right = r;

        // 记录数组第一个元素为基准值
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                arr[right] = arr[left];
            }

            // 将pivot放置到两指针相遇位置
            if (left >= right) {
                arr[left] = pivot;
            }
        }

        // 递归左子数组
        quickSort(arr, l, right - 1);
        // 递归右子数组
        quickSort(arr, right + 1, r);
    }

}
