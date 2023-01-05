package com.lkl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合问题
 * @author likelong
 * @date 2022/12/29
 */
public class LC77 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);
        return ans;
    }

    public void backtracking(int start, int end, int k) {
        if (path.size() == k) {
            // 元素数量达到目标数量，存放结果
            ans.add(new ArrayList<>(path));
            return;
        }

        // 剪枝，去除没必要的循环 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n(end)
        // 搜索上界 = n + 1 - 接下来要选择的元素个数
        // n + 1 - (k - path.size())  for循环 树的宽度 剪枝 从树的宽度入手
        for (int i = start; i <= end + 1 - (k - path.size()); i++) {
            path.add(i);
            System.out.println("递归之前 => " + path);
            // 递归 start 开始位置，不停向后移动 递归之后回溯撤销处理结果 树的深度
            backtracking(i + 1, end, k);
            // 回溯，撤销处理结果
            path.remove(path.size() - 1);
            System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        LC77 solution = new LC77();
        int n = 4;
        int k = 4;
        List<List<Integer>> res = solution.combine(n, k);
        System.out.println(res);
    }

}
