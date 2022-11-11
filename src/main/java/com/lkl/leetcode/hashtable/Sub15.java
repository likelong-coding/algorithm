package com.lkl.leetcode.hashtable;

import java.util.*;

/**
 * @author likelong
 * @date 2022/11/11
 */
public class Sub15 {
    public List<List<Integer>> threeSum(int[] nums) {
        long start = System.currentTimeMillis();
        List<List<Integer>> ans = new ArrayList<>();

        //暴力法 理论可行，数据量大的话会超时，时间复杂度O(n^3) 7388ms
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

        //哈希法
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (map.containsKey(-(nums[i] + nums[j]))) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[map.get(-(nums[i] + nums[j]))]);
                    //先将集合排序然后手动去重
                    Collections.sort(list);
                    if (!ans.contains(list)) {
                        ans.add(list);
                    }
                }
            }
        }


        System.out.println("it costs time " + (System.currentTimeMillis() - start) + "ms");

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Sub15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
