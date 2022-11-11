package com.lkl.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 ——梦开始的地方
 *
 * @author likelong
 * @date 2022/11/11
 */
public class Sub1 {

    public int[] twoSum(int[] nums, int target) {
        //1、双重循环暴力法
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }

        //2、哈希法
        /*
        为什么会想到用哈希表？
        快速判断元素是否出现过
        哈希表为什么用map？
        我们不仅要判断元素是否出现过，还需要找到其对应下标
        map中的key和value用来存什么的？
        由上即可知，key可以存数字，value存数字下标

        --将下一个元素放到map中之前，判断 `target - 当前元素` 在map中是否存在，
        --存在将对应两数下标放到结果中，直接返回结果
         */
        //数字->数字对应下标（为什么是下标呢，因为我们要返回的是下标）
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};

        System.out.println(Arrays.toString(new Sub1().twoSum(nums, 6)));

    }


}
