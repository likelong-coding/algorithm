package com.lkl.leetcode.hashtable;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author likelong
 * @date 2022/11/12
 */
public class Sub18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }
        //类似三数之和？ 排序 + 双指针？
        Arrays.sort(nums);
        long first, second, third, four;
        for (int i = 0; i < nums.length - 3; i++) {
            first = nums[i];
            //去重，找数时，相邻两数相等直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                second = nums[j];
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                //最后两个数
                long other = target - (first + second);
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    third = nums[left];
                    four = nums[right];
                    if (third + four == other) {
                        ans.add(Arrays.asList((int) first, (int) second, (int) third, (int) four));
                        //跳过 去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (third + four < other) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return ans;
    }

    @Test
    public void test() {
//        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
//        int target = -11;
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }
}
