package com.lkl.leetcode.greedy;

import java.util.Arrays;

/**
 * 135. 分发糖果
 *
 * @author likelong
 * @date 2023/1/11
 */
public class LC135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] needCandy = new int[n];

        // 默认都是一颗糖果
        Arrays.fill(needCandy, 1);

        // 先从左向右，看右边评分是否比左边的大
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // 评分更高。糖果数量 + 1
                needCandy[i] = needCandy[i - 1] + 1;
            }
        }

        // 从右向左
        for (int i = n - 1; i >= 1; i--) {
            // 右边评分比左边高，并且右边糖果小于左边糖果
            if (ratings[i - 1] > ratings[i] && needCandy[i - 1] <= needCandy[i]) {
                needCandy[i - 1] = needCandy[i] + 1;
            }
        }

        // 所有糖果和
        return Arrays.stream(needCandy).sum();
    }
}
