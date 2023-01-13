package com.lkl.leetcode.greedy;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * @author likelong
 * @date 2023/1/12
 */
public class LC435 {

    /*
    重叠区间怎么区分呢？
    主要是看上一个数对的结束位置是否在当前数对区间内，即需要和当前数对的开始、结束位置相比较
    为了比较方便，可以直接按数对结束位置进行从小到大排序，这样就可以不需关注数对结束位置，
    只关注上一个数对结束位置与当前数对开始位置相比结果即可。

    分两种情况：
    ①如果上一个数对结束位置大于当前数对开始位置，说明存在重叠区间，移除数量 + 1
    ②反之上一个数对结束位置小于等于当前数对开始位置，这两个区间不存在重叠区间，
    此时需要更新上一个数对结束位置为当前数对结束位置，继续和下一个数对开始位置进行比较直到遍历结束

    为了方便，可以从第二个数对开始操作，初始化上一个数对结束位置为第一个数对结束位置
     */

    public int eraseOverlapIntervals(int[][] intervals) {
        int sum = 0;
        // 先排序 按结束位置从小到大排序
        Arrays.sort(intervals, ((o1, o2) -> o1[1] - o2[1]));
        // 默认上一个数对结束位置为第一个数对结束位置
        int preEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];

            if(preEnd > curStart){
                // 存在重叠区间
                sum++;
            }else {
                // 不存在重叠区间，更新上一个数对结束位置
                preEnd = intervals[i][1];
            }
        }
        return sum;
    }
}
