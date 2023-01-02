package com.lkl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author likelong
 * @date 2023/1/1
 */
public class LC39 {

    /**
     * 最后返回结果
     */
    List<List<Integer>> ans = new ArrayList<>();
    /**
     * 单一结果 同时用于回溯
     */
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0);
        return ans;
    }

    /**
     * 回溯
     * @param candidates 整数数组
     * @param targetSum 目标和
     * @param sum 当前和
     */
    public void backtracking(int[] candidates, int targetSum, int sum) {
        if(sum == targetSum){
            // 递归终止条件
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int num : candidates) {
            sum += num;
            path.add(num);
            // 递归
            backtracking(candidates, targetSum, sum);
            // 回溯
            sum -= num;
            path.remove(path.size() - 1);
        }
    }
}
