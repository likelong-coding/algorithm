package com.lkl.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author likelong
 * @date 2022/11/8
 */
public class Sub242 {
    public boolean isAnagram(String s, String t) {
        //长度不等直接返回false
        if (s.length() != t.length()) {
            return false;
        }

        //字符数组排序过后应该相等
//        char[] ch1 = s.toCharArray();
//        char[] ch2 = t.toCharArray();
//        Arrays.sort(ch1);
//        Arrays.sort(ch2);
//        return Arrays.equals(ch1, ch2);

        //26个小写字母 不需要记住a-z ASCII码值，只需 - 'a' ，下标就是从零开始
        //由数组充当哈希表
        int[] records = new int[26];
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a'] += 1;
        }

        System.out.println(Arrays.toString(records));

        for (int i = 0; i < t.length(); i++) {
            records[t.charAt(i) - 'a'] -= 1;
        }
        System.out.println(Arrays.toString(records));

        for (int record : records) {
            if (record != 0) {
                return false;
            }
        }
        return true;
    }

    public Map<Integer, Integer> getCharCount(String str) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i) - 'a', map.getOrDefault(map.get(str.charAt(i) - 'a'), 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(new Sub242().isAnagram("rat", "car"));
    }
}
