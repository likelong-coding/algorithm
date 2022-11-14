package com.lkl.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/11/14
 */
public class Sub541 {

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        // 左右双指针
        int j;
        for (int i = 0; i < s.length(); i += 2 * k) {
            j = i + k - 1;
            if (s.length() - 1 - i < k) {
                //兼容第一种情况
                swap(arr, i, s.length() - 1);
                break;
            } else {
                swap(arr, i, j);
            }
        }
        return new String(arr);
    }

    public void swap(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test() {
        String str = "krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc";

        System.out.println(reverseStr(str, 20));
    }

}
