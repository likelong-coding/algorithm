package com.lkl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 两种解法：①借助额外数组，标记元素是否被取过，被取过直接跳过，否则对额外数组赋值，回溯也要撤销其操作
 * ②不借助额外空间，充分利用，题目特点，数组中所有整数互不相同，因此说明每种结果不可能有重复元素
 * @author likelong
 * @date 2023/1/3
 */
public class LC46 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return ans;
    }

    // 不借助额外数组空间
    public void backtracking(int[] nums){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // 题目 nums 中的所有整数 互不相同，因此说明每种结果不可能有重复元素
            if(!path.contains(nums[i])){
                path.add(nums[i]);
                // 递归
                backtracking(nums);
                // 回溯
                path.remove(path.size() - 1);
            }
        }
    }
}
