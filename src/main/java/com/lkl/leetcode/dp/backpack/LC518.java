package com.lkl.leetcode.dp.backpack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 *
 * @author likelong
 * @date 2023/2/7
 */
public class LC518 {

    public int change(int amount, int[] coins) {

        // 类完全背包问题 【装满容量背包有多少种装法】
        int[] dp = new int[amount + 1];
        // 初始化，背包容量为0，不装也是一种方案
        dp[0] = 1;

        // 组合个数
        for (int coin : coins) {
            // 背包容量正序【每个物品都有无限个】
            for (int j = coin; j <= amount; j++) {
                // 装满背包有几种方法，统一递推公式
                dp[j] += dp[j - coin];
            }
        }

        // 排列个数
        // 背包容量
//        for (int i = 0; i <= amount; i++) {
//            // 物品重量
//            for (int coin : coins) {
//                if (i >= coin) {
//                    dp[i] += dp[i - coin];
//                }
//            }
//        }

        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    @Test
    public void test() {
        int[] coins = new int[]{1, 5};
        change(6, coins);
    }
}
