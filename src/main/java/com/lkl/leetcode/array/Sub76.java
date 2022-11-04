package com.lkl.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author likelong
 * @date 2022/10/25
 */
public class Sub76 {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        //统计所需字符及其数量
        Map<Character, Integer> need = new HashMap<>(16);
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        //统计窗口内的字符及其数量
        Map<Character, Integer> window = new HashMap<>(16);

        //i,j 左右指针
        int i = 0;
        //记录字符满足数量
        int valid = 0;
        //记录窗口大小
        int min = Integer.MAX_VALUE;
        //记录左下标
        int left = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch1 = s.charAt(j);
            window.put(ch1, window.getOrDefault(ch1, 0) + 1);

            //窗口内字符数量与所需字符数量相等
            if (window.get(ch1).equals(need.get(ch1))) {
                valid++;
            }

            //移动左下标（移动窗口）
            while (valid == need.size()) {

                if (j - i + 1 < min) {
                    min = j - i + 1;
                    left = i;
                }
                char ch2 = s.charAt(i);
                if (window.get(ch2).equals(need.get(ch2))) {
                    valid--;
                }
                window.put(ch2, window.get(ch2) - 1);
                i++;
            }

        }

        return min == Integer.MAX_VALUE ? "" : s.substring(left, left + min);
    }

    public static void main(String[] args) {
        System.out.println(new Sub76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
