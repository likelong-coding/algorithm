package com.lkl.leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. 合并区间
 * @author likelong
 * @date 2023/1/13
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        // 按开始位置从小到大排序，开始位置相同时，结束位置从大到小排序
        // 保证上一个元素区间范围较大 尽量把大的区间放在前面方便操作
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        List<int[]> ans = new LinkedList<>();
        // 先将第一个数对放入结果 可能直接就是最大区间范围
        ans.add(intervals[0]);
        // 直接从第二个数对开始遍历
        for (int i = 1; i < intervals.length; i++) {
            int lastIndex = ans.size() - 1;
            int[] preInterval = ans.get(lastIndex);
            int[] curInterval = intervals[i];

            // 上一个数对结束位置与当前数对开始位置相比
            if (preInterval[1] >= curInterval[0]) {
                // 开始位置不用更改，上一个数对开始位置小于等于当前数对开始位置
                // 更新结束位置
                preInterval[1] = Math.max(preInterval[1], curInterval[1]);
                // 更新元素
                ans.set(lastIndex, preInterval);
            } else {
                // 上个数对结束位置还小于当前数对开始位置
                // 一定不存在重叠区间！！！ 直接添加元素 【先把一定确定的确定】
                ans.add(curInterval);
            }
        }
        return ans.toArray(new int[0][0]);
    }
}
