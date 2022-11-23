package com.lkl.leetcode.string.kmp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    public int strStr1(String haystack, String needle) {
        //前缀表
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    /***
     * KMP算法，匹配元素不相等时，从字串最长公共前后缀长度位置开始继续匹配
     * 获取前缀表 next数组代表当前字串最长公共前后缀长度
     * aabaaf [0 1 0 1 2 0]
     *
     * aba
     *
     * abcd
     */
    public int[] getNext(String str) {
        int[] next = new int[str.length()];
        //第一位为0
        next[0] = 0;

        // j 代表最长公共前缀的长度以及遍历位置
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            //前后缀不相等的情况 向前回退
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                //KMP
                j = next[j - 1];
            }

            //前后缀相等的情况
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            //更新next数组
            next[i] = j;
        }
        return next;
    }

    @Test
    public void test() {
        System.out.println(strStr("sattdsad", "sad"));

        System.out.println(Arrays.toString(getNext("aba")));
    }
}
