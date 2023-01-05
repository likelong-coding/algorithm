package com.lkl.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集问题
 * @author likelong
 * @date 2023/1/3
 */
public class LC78 {

    /*
    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return ans;
    }

    /**
     * startIndex 每次开始找元素索引
     * 如果把 子集问题、组合问题、分割问题都抽象为一棵树的话，
     * 那么组合问题和分割问题都是收集树的叶子节点，而子集问题是找树的所有节点！
     */
    public void backtracking(int[] nums, int startIndex) {
        // 收集树的所有节点 全是子集
        ans.add(new ArrayList<>(path));
        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            // 递归 取过的元素不能再取 i + 1
            backtracking(nums, i + 1);
            // 回溯
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
