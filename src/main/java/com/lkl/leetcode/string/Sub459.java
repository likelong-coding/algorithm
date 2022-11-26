package com.lkl.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/11/25
 */
public class Sub459 {
    public boolean repeatedSubstringPattern(String s) {
        //拼接去头去尾包含匹配
//        String str = s + s;
//        return str.substring(1, str.length() - 1).contains(s);

        int[] next = getNext(s);
        if (next[next.length - 1] == 0) {
            return false;
        }

        //看原字符串长度是否能除尽子字符串长度
        return s.length() % (s.length() - next[next.length - 1]) == 0;
    }


    /**
     * 如果是重复子字符串，前缀表最后一个元素就是最长的公共前后缀长度
     * 而子字符串就是除去最长公共前后缀的部分
     */
    public int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;

        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        return next;
    }

    @Test
    public void test() {
        System.out.println(repeatedSubstringPattern("acac"));
    }
}
