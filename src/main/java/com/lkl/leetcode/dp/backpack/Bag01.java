package com.lkl.leetcode.dp.backpack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 纯0-1背包代码实现
 * @author likelong
 * @date 2023/2/2
 */
public class Bag01 {

    public int bag(int[] weights, int[] value, int bagWeight) {
        int m = weights.length;

        // dp[i][j]：表示物品编号0-i，放入背包承受重量j的最大价值为 dp[i][j]
        int[][] dp = new int[m][bagWeight + 1];

        // 初始化：第一行，背包容量大于 第一个物品重量weight[0]，初始化为value[0]
        // 第一列：背包容量为0，最大价值初始化为0，int类型默认值就是0因此无需初始化

        // j 代表背包容量
        for (int j = 1; j <= bagWeight; j++) {
            if (j >= weights[0]) {
                dp[0][j] = value[0];
            }
        }

        /*
        递推公式：
        物品无非就是两种状态，放入、不放入，找到这两种状态的价值最大值
        不放入：价值最大值为 dp[i - 1][j] 【不放入物品i，即在 0 - i-1 物品中得到最大价值】
        放入：物品i价值 + 除去物品i 的最大价值即是放入物品i的最大价值 value[i] + dp[i - 1][j - weight[i]] 【放入物品i，此时背包容量即为j - weight[i]】

        此时最大价值就是两者最大值 Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]) 【前提是当前背包容量大于当前物品重量】
         */

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if (j >= weights[i]) {
                    // 可以放入物品i
                    // 分两种情况，放入、不放入取最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weights[i]]);
                } else {
                    // 不放入物品i最大价值
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m - 1][bagWeight];
    }

    /**
     * 对空间复杂度进行优化，由2维数组优化成1维数组 【状态压缩】
     */
    public int bag2(int[] weights, int[] value, int bagWeight) {
        int n = weights.length;
        int[] dp = new int[bagWeight + 1];

        // initialization
        for (int j = 0; j <= bagWeight; j++) {
            if (j > weights[0]) {
                dp[j] = value[0];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = bagWeight; j >= weights[i]; j--) {
                if (j >= weights[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + value[i]);
                }
                // 不大于的时候，继承原来的值，不用改。
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[bagWeight];
    }

    @Test
    public void test1() {
//        int[] weights = new int[]{1, 3, 4, 5};
//        int[] value = new int[]{1, 4, 5, 7};
//        bag(weights, value, 7);

        int[] weights = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        System.out.println(bag2(weights, value, 4));
    }

}
