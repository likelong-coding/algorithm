package com.lkl.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/11/25
 */
public class Sub459 {
    public boolean repeatedSubstringPattern(String s) {

        StringBuilder sub = new StringBuilder();
        //获得子串
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && sub.charAt(0) == s.charAt(i)) {
                break;
            }
            sub.append(s.charAt(i));
        }

        if (sub.length() > 0 && s.length() % sub.length() != 0) {
            return false;
        }


        for (int loop = sub.length(); loop < s.length(); loop += sub.length()) {
            int i = loop;
            int j = 0;

            while (j < sub.length() && s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            }

            if (s.charAt(i - 1) != sub.charAt(j - 1)) {
                return false;
            }
        }


        return true;
    }

    @Test
    public void test() {
        System.out.println(repeatedSubstringPattern("abac"));
    }
}
