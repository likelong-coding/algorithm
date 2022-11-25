package com.lkl.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/11/25
 */
public class Sub459 {
    public boolean repeatedSubstringPattern(String s) {

        if (s.length() == 1) {
            return false;
        }

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


        for (int i = sub.length(); i < s.length(); ) {
            for (int j = 0; j < sub.length(); ) {
                if (s.charAt(i++) != sub.charAt(j++)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test() {
        System.out.println(repeatedSubstringPattern("abaaba"));
    }
}
