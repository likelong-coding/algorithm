package com.lkl.leetcode.array;

import java.util.Arrays;

/**
 * @author likelong
 * @date 2022/10/27
 */
public class Sub59 {
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int num = 1;
        //每次转圈起始位置，对角线
        int start = 0;
        //转圈几次，n/2 n如果是奇数，中心位置元素单独赋值
        int loop = 0;
        int i = 0;
        int j = 0;
        int offset = 1;
        //顺时针
        while (loop++ < n / 2) {
            //整体左闭右开
            //上->左到右
            i = start;
            j = start;
            for (; j < n - offset; j++) {
                ans[i][j] = num++;
            }

            //右->上到下
            for (; i < n - offset; i++) {
                ans[i][j] = num++;
            }

            //下->右到左
            for (; j > start; j--) {
                ans[i][j] = num++;
            }

            //左->下到上
            for (; i > start; i--) {
                ans[i][j] = num++;
            }
            offset++;
            start++;
        }

        //奇数
        if (n % 2 == 1) {
            ans[n / 2][n / 2] = n * n;
        }

        //奇数，中心位置单独处理
        if (n % 2 == 1) {
            ans[n / 2][n / 2] = n * n;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
