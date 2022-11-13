package com.lkl.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @author likelong
 * @date 2022/11/11
 */
public class Sub15 {
    public List<List<Integer>> threeSum(int[] nums) {
        long start = System.currentTimeMillis();
        List<List<Integer>> ans = new ArrayList<>();

        //暴力法 理论可行，数据量大的话会超时，时间复杂度O(n^3) 4423ms
        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                for (int k = j + 1; k < len; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        ArrayList<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(nums[k]);
//                        //先将集合排序然后手动去重
//                        Collections.sort(list);
//                        if (!ans.contains(list)) {
//                            ans.add(list);
//                        }
//                    }
//
//                }
//            }
//        }

        //先看两个数之和为0，可以先将数组排序，左右双指针法，两数之和小于0左指针移动，两数之和大于0右指针移动，如果相等的话，左右指针同时移动
        //此时在移动的过程中，如果相邻数字想等直接跳过即可

        // 排序 + 双指针 一个数 与 两个数之和 的和为0 32ms

        Arrays.sort(nums);
        int first;
        int second;
        int third;
        for (int i = 0; i < len; i++) {
            //第一个数
            first = nums[i];
            //第一个数大于0.直接跳出循环返回结果
            if (first > 0) {
                break;
            }

            //这个数，遍历过程中如果相邻元素相等直接跳过即可
            //后一个数与前一个数相同直接跳过
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            //其他两个数
            int target = -first;
            //左右双指针，从第一个数后一个数开始
            int l = i + 1, r = len - 1;
            while (l < r) {
                second = nums[l];
                third = nums[r];
                if (second + third == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(third);
                    ans.add(list);
                    //左指针遇到相同的数，跳过
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    //右指针遇到相同的数，跳过
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (second + third < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        System.out.println("it costs time " + (System.currentTimeMillis() - start) + "ms");

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Sub15().threeSum(new int[]{0, 0, 0}));
    }
}
