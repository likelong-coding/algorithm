package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/10/22
 */
public class Sub977 {
    public int[] sortedSquares(int[] nums) {

        //普通解法：最直观，直接把所有元素的平方直接放到数组里，再用工具类排序
        // int[] res = new int[nums.length];

        // for(int i = 0; i < nums.length; i++){
        //   res[i] =  nums[i] * nums[i];
        // }

        // Arrays.sort(res);
        // return res;

        //进阶解法：双指针法，元素平方最大应该是在两端
        int[] res = new int[nums.length];
        // 左到右
        int left = 0;
        // 右到左
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            //每次都找到元素平方最大值
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                res[index] = nums[right] * nums[right];
                right--;
            } else {
                res[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return res;
    }
}
