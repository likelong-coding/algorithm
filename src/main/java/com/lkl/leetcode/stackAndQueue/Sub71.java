package com.lkl.leetcode.stackAndQueue;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/12/1
 */
public class Sub71 {

    public String simplifyPath(String path) {

        StringBuilder sb = new StringBuilder();

        char[] ch = path.toCharArray();
        for (int i = 0; i < ch.length; ) {
            char c = ch[i];
            if (c != '.') {
                sb.append(c);
            } else {
//                if ()

                if (sb.length() - 1 > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            i++;
        }

        if (ch.length - 1 > 1 && sb.charAt(sb.length() - 1) == '/') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/../"));
    }
}
