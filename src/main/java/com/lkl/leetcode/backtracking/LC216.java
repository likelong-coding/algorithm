package com.lkl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和III
 * @author likelong
 * @date 2022/12/30
 */
public class LC216 {

    /**
     * 最后返回结果
     */
    List<List<Integer>> ans = new ArrayList<>();
    /**
     * 单一结果 同时用于回溯
     */
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n) {
            return ans;
        }

        backtracking(k, n, 0, 1);
        return ans;
    }

    /**
     * 回溯
     *
     * @param k         k个数组合
     * @param targetSum 目标和
     * @param sum       当前和
     * @param start     开始位置（下标）
     */
    public void backtracking(int k, int targetSum, int sum, int start) {
        // 当前和大于目标和直接return;  剪枝
        if (sum > targetSum) {
            return;
        }

        // 列表中元素数量 大于组合数量 return; 剪枝
        if (list.size() > k) {
            return;
        }

        // 递归终止条件
        if (list.size() == k && targetSum == sum) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // 剪枝 树的宽度入手
        for (int i = start; i <= 10 - (k - list.size()); i++) {
            list.add(i);
            sum += i;
            // 递归
            System.out.println("递归之前 => " + list);
            backtracking(k, targetSum, sum, i + 1);
            // 递归之后回溯，撤销处理结果
            list.remove(list.size() - 1);
            sum -= i;
            System.out.println("递归之前 => " + list);
        }
    }

    public static void main(String[] args) {
        LC216 lc216 = new LC216();

        List<List<Integer>> ans = lc216.combinationSum3(3, 7);
        System.out.println(ans);
    }

}
