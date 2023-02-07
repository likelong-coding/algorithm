package com.lkl.leetcode.dp.backpack;

import org.junit.jupiter.api.Test;

/**
 * 纯完全背包代码实现
 *
 * @author likelong
 * @date 2023/2/7
 */
public class CompleteBag {

    /*
        0-1背包和完全背包唯一的区别就是0-1背包所有物品都只有一个，而完全背包
        每个物品有无限个

        0-1一维dp解决方案，双重循环，外层正序遍历物品重量，内层倒序遍历背包容量，之所以倒序就是为了保证每个物品只能放置一次
        所以完全背包和0-1背包类似，内层循环直接正序遍历即可，因为每个物品都是有无限个
     */

    public int completeBag(int[] weights, int[] value, int bagWeight) {

        // dp[j] 表示背包容量为j，填充背包所得到的物品最大价值为 dp[j]
        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j <= bagWeight; j++) {
//                if (j >= weights[i]) {
                // 抽象成二维数组的话都是从上一层左边推导出来的，因此双重循环调换位置也是不影响结果的
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + value[i]);
//                }
            }
        }
        return dp[bagWeight];
    }

    @Test
    public void test() {
        int[] weights = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        System.out.println(completeBag(weights, value, 4));
    }
}
