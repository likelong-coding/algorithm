package com.lkl.leetcode.hashtable;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 *
 * @author likelong
 * @date 2022/11/10
 */
public class Sub350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //方式一：借助List
//        if (nums1.length < nums2.length) {
//            return getResult(nums1, nums2);
//        } else {
//            return getResult(nums2, nums1);
//        }
        List<Integer> ans = new ArrayList<>();
        //方式二：借助Map
        // key是数字，value是数字出现次数
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums1) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        for (int num : nums2) {
//            Integer count = map.get(num);
//
//            if (count != null && count > 0){
//                ans.add(num);
//                //--count 先减再赋值，此时数已经-1 ; count-- 先赋值再-1，此时数字还未发生改变
//                map.put(num, --count);
//            }
//        }

        //方式三：将两数组排序，双指针法，不需要借助额外空间
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //双指针
        int i = 0,j = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]) {
                i++;
            }else if (nums1[i] > nums2[j]){
                j++;
            }else {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }

    public int[] getResult(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> cacheNum = new ArrayList<>();

        for (int num : nums1) {
            cacheNum.add(num);
        }
        for (int num : nums2) {
            if (cacheNum.contains(num)) {
                //移除元素，不是移除下标元素
                cacheNum.remove(Integer.valueOf(num));
                ans.add(num);
            }

            if (cacheNum.isEmpty()) {
                break;
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(new Sub350().intersect(nums1, nums2)));
    }
}
