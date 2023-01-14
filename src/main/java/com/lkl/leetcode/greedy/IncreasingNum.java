package com.lkl.leetcode.greedy;

/**
 * 738. 单调递增的数字
 * @author likelong
 * @date 2023/1/14
 */
public class IncreasingNum {

    public int monotoneIncreasingDigits(int n) {

        // 暴力超时
        // 找到满足条件最大值，可以倒序
        // for(int i = n; i >= 0; i--){
        //     if(isValid(i)){
        //         return i;
        //     }
        // }
        // return -1;

        // 正确姿势 从后往前遍历所有数字 当 n[i - 1] > n[i] 时，n[i - 1]--; i - 1后面所有元素都变为 '9'
        // 假设是从前往后的话，遍历过的元素就不太好重新遍历了
        // 例如：332 如果是从前往后，第一次变为 329 实际上 3 < 2 ，应该还有一次变化 299，从前往后就不太好操作
        // 如果是从后往前的话，第一次 329， 这样还会有第二次直接变成 299 便得到了最后结果
        char[] chs = (n + "").toCharArray();
        for (int i = chs.length - 1; i >= 1; i--) {
            if (chs[i] < chs[i - 1]) {
                // 当前元素 -1
                chs[i - 1]--;
                // 从当前位置i开始后面所有元素都变为 '9'
                for (int j = i; j < chs.length; j++) {
                    chs[j] = '9';
                }
            }
        }

        return Integer.parseInt(new String(chs));
    }

    public boolean isValid(int sum) {
        // 上一位数字
        int preDigit = -1;
        while (sum != 0) {
            int curDigit = sum % 10;
            if (preDigit != -1 && preDigit < curDigit) {
                return false;
            }
            preDigit = curDigit;
            sum /= 10;
        }

        return true;
    }
}
