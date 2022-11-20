package com.lkl.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/11/17
 */
public class Sub28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        //暴力解法
        int i = 0;
        int j = 0;
        int ans = -1;
        while (i < haystack.length()) {
            char ch1 = haystack.charAt(i);
            char ch2 = needle.charAt(j);
            if (ch1 == ch2) {
                if (j == needle.length() - 1) {
                    ans = i - j;
                    break;
                }
                i++;
                j++;
            } else {
                //回头继续找，在上次查找位置向前移动一个位置继续查找
                i = i - j + 1;
                j = 0;
            }
        }

        return ans;
    }

    @Test
    public void test() {
        System.out.println(strStr("sattdsad", "sad"));
    }
}
