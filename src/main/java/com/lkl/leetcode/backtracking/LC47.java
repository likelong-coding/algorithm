package com.lkl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列Ⅱ
 * @author likelong
 * @date 2023/1/4
 */
public class LC47 {

    /*
    结果去重有两种方式：
    ①排序，将相同的元素搞到一块，然后同层有相同的元素直接跳过
    ②无法排序的，只能每层借助额外空间进行去重
     */

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 排序将相同的元素安排到一起
        Arrays.sort(nums);
        // used 数组标记元素是否取过了，取过的元素不能再取了
        backtracking(nums, new boolean[nums.length]);
        return ans;
    }

    public void backtracking(int[] nums, boolean[] used){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            // 同层元素去重，排过序的，后一个元素与前一个元素相同并且前一个元素已经取过了
            // used[i - 1] == false 树层去重，这种效率会更高一点
            // used[i - 1] == true  树枝去重，几乎要枚举所有结果，效率不高
            // 上面两种都可以
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            // 用过的元素不能在用了，直接跳过
            if(used[i]){
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, used);
            // 回溯撤销操作
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
