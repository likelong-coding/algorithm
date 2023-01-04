package com.lkl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author likelong
 * @date 2023/1/3
 */
public class LC90 {

    // 最终返回结果
    List<List<Integer>> ans = new ArrayList<>();
    // 单一结果
    List<Integer> path = new ArrayList<>();
    // 排序 + 同层去重
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先将 数组排序，方便同层跳过相同元素 ！！！
        Arrays.sort(nums);
        backtracking(nums, 0);
        return ans;
    }

    // startIndex 取过的元素，不用再取了
    public void backtracking(int[] nums, int startIndex){
        // 收集子集，所有节点
        ans.add(new ArrayList<>(path));

        // 这个终止条件，可有可无，因为有for循环可以控制递归结束
        // if(path.size() == nums.length) return;

        for(int i = startIndex; i < nums.length; i++){
            // 树的同一层需要去重 ！！！
            if(i > startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
