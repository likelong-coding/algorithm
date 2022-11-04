package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/10/23
 */
public class Sub209 {

    public int minSubArrayLen(int target, int[] nums) {

        // // 暴力解法，理论可行但是超时了
        // // 记录连续数组长度
        // int length = 0;
        // // 记录连续数组最小长度
        // int minLength = Integer.MAX_VALUE;
        // for(int i = 0; i < nums.length; i++){
        //     int sum = 0;
        //     for(int j = i; j < nums.length; j++){
        //         sum += nums[j];

        //         if(sum >= target){
        //            //连续数组长度
        //            length = j - i + 1;
        //            if(length < minLength){
        //                //满足条件记录连续数组最小长度
        //                minLength = length;
        //            }
        //         }
        //     }
        // }
        // // 没有被赋值说明没有满足条件的连续数组
        // return minLength == Integer.MAX_VALUE ? 0 : minLength;


        //滑动窗口
        // 起始位置
        int i = 0;
        // 记录连续数组长度
        int length = 0;
        // 记录连续数组最小长度
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        // j记录终止位置，滑动起始i的位置
        for (int j = 0; j < nums.length; j++) {
            //sum值在原本基础上累加
            sum += nums[j];

            //起始位置可能持续移动，不能用if判断
            while (sum >= target) {
                length = j - i + 1;
                if (length < minLength) {
                    minLength = length;
                }

                // 移动起始位置
                sum -= nums[i];
                i++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
