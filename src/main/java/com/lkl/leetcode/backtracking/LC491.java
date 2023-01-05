package com.lkl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增子序列
 * @author likelong
 * @date 2023/1/3
 */
public class LC491 {

    /*
    输入：nums = [4,6,7,7]
    输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
     */

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return ans;
    }

    public void backtracking(int[] nums, int startIndex) {
        if(path.size() > 1){
            ans.add(new ArrayList<>(path));
        }

        // 同层元素 使用 list 去重
        List<Integer> list = new ArrayList<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 同一层有相同元素直接跳过
            if(list.contains(nums[i])){
                continue;
            }

            // 下一个元素小于 path 中最后一个元素直接跳过
            if(!path.isEmpty() && path.get(path.size() - 1) > nums[i]){
                continue;
            }

            // 每层都会新创建一个 list 因此无需回溯
            list.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
