package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/10/20
 */
public class Sub367 {
    public boolean isPerfectSquare(int num) {
        // 第一种：比较好理解，时间复杂度高一点，但是空间复杂度低
        // int i = 1;
        // while((long)i * i < num){
        //     i++;
        // }

        // if(i * i == num){
        //     return true;
        // }
        // return false;

        // 第二种：二分法，时间复杂度低，空间复杂度高
        int left = 1;
        int right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= num) {
                if (mid * mid == num) {
                    return true;
                }

                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
