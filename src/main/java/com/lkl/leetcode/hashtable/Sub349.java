package com.lkl.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 *
 * @author likelong
 * @date 2022/11/10
 */
public class Sub349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }

        //将集合转为数组 流式计算
        return ans
                .stream()
                // Integer::intValue -> x -> x 也是OK的
                .mapToInt(Integer::intValue)
                .toArray();

    }
}
