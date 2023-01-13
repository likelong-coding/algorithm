package com.lkl.leetcode.greedy;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * 判断气球位置是否有公共区间
 * @author likelong
 * @date 2023/1/12
 */
public class LC452 {

    public int findMinArrowShots(int[][] points) {

        // 根据气球结束位置 从小到大排序 (o1, o2) -> return o1[1] - o2[1]; 会有 Integer两个边界相减 溢出情况
        // Integer.MAX_VALUE - Integer.MIN_VALUE = -1
        Arrays.sort(points, (o1, o2) -> o1[1] > o2[1] ? 1 : -1);
        // 第一个气球肯定需要需要一只箭
        int count = 1;

        // 上个气球结束位置
        int preEnd = points[0][1];
        // 从第二个气球开始
        for (int i = 1; i < points.length; i++) {
            int curStart = points[i][0];
            // 由于我们是按 结束位置 从小到大排序的，上个气球的结束位置只需和当前气球开始位置相比即可
            // 满足条件 弓箭数 + 1，同时更新上个气球结束位置
            if (preEnd < curStart) {
                count++;
                preEnd = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // -1 Integer 边界溢出
        System.out.println(Integer.MAX_VALUE - Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
