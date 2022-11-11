package com.lkl.leetcode.hashtable;

/**
 * @author likelong
 * @date 2022/11/11
 */
public class Sub383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        //`都是由小写字母组成`，可以使用定长数组当作哈希表，索引是字符ASCII码值，对应值就是字母出现次数
        // 小写字母 - 'a' 索引就是从 0-25
        int[] records = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            records[ransomNote.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < magazine.length(); i++) {
            records[magazine.charAt(i) - 'a'] -= 1;
        }

        for (int record : records) {
            if (record > 0) {
                //说明前者中某个元素数量 大于 后者
                return false;
            }
        }

        return true;
    }
}
