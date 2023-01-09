package com.lkl.leetcode.random;

import org.junit.jupiter.api.Test;

/**
 * 50. Pow(x, n)
 *
 * @author likelong
 * @date 2023/1/6
 */
public class MyPow {
    double ans = 1;
    /**
     * count 控制递归次数
     */
    int count = 0;

    public double myPow(double x, int n) {
        double ans = 1;
        // 标识是否是负数
        boolean flag = false;
        long count = n;
        if (x == 0 || x == 1) {
            return x;
        }

        if (count < 0) {
            flag = true;
            count = -count;
        }

        for (int i = 0; i < count; i++) {
            ans *= x;
        }
        return flag ? (1.0 / ans) : ans;
    }

    public void recursion(double x, int n) {
        if (count == n) {
            return;
        }

        ans *= x;
        count++;
        recursion(x, n);
    }

    @Test
    public void test() {
        System.out.println(Math.pow(2, -2147483648));
        System.out.println(myPow(2, -2147483648));

    }
}
