package com.lkl.leetcode.dp.backpack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 多重背包
 *
 * @author likelong
 * @date 2023/2/14
 */
public class MultiBag {

    public void testMultiPack1() {
        // 版本一：改变物品数量为01背包格式（多重背包转换为0-1背包）
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;

        for (int i = 0; i < nums.size(); i++) {
            // 转化为0-1背包
            while (nums.get(i) > 1) {
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i, nums.get(i) - 1);
            }
        }

        int[] dp = new int[bagWeight + 1];
        // 遍历物品
        for (int i = 0; i < weight.size(); i++) {
            // 遍历背包容量 （倒序保证每个物品只能取一次，【此时已转换成了0-1背包】）
            for (int j = bagWeight; j >= weight.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }
    }

    public void testMultiPack2(){
        // 版本二：01背包基础上还要遍历物品个数
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};
        int[] nums = new int[] {2, 3, 2};
        int bagWeight = 10;

        int[] dp = new int[bagWeight + 1];
        // 遍历物品
        for(int i = 0; i < weight.length; i++) {
            // 遍历背包容量
            for(int j = bagWeight; j >= weight[i]; j--) {
                // 在01背包的基础上，然后加一个遍历个数
                for (int k = 1; k <= nums[i] && (j - k * weight[i]) >= 0; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
    }

    @Test
    public void test() {
        testMultiPack2();
    }
}
