package com.lkl.leetcode.greedy;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author likelong
 * @date 2023/1/9
 */
public class LC122 {


    /*
    局部递增最大的两个峰值差
     */

    public int maxProfit(int[] prices) {

        int profit = 0;
        if (prices.length == 1) {
            return profit;
        }

        int curDiff;
        for (int i = 1; i < prices.length; i++) {
            curDiff = prices[i] - prices[i - 1];

            if (curDiff > 0) {
                profit += curDiff;
            }
        }

        return profit;
    }
}
