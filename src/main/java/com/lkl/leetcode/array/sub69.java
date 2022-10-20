package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/10/20
 */
public class sub69 {

    //相当于找中间元素，类似二分查找
    public int mySqrt(int x) {
        // 第一种解法：二分查找
        //   int left = 0;
        //   int right = x;
        //   int res = -1;
        //   while(left <= right){
        //     int mid = (left + right) / 2;
        //     if((long)mid * mid <= x){
        //        res = mid;
        //        left = mid + 1;
        //     }else {
        //         right = mid - 1;
        //     }
        //   }

        //   //找到中间位置元素
        //   return res;

        // 第二种更加容易理解，上面二分查找效率更高
        int i = 1;
        //范围可能超过int型范围，因此转成long型
        while ((long) i * i <= x) {
            i++;
        }
        return (i - 1);
    }
}
