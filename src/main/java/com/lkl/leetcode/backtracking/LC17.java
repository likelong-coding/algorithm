package com.lkl.leetcode.backtracking;

import java.util.*;

/**
 * @author likelong
 * @date 2022/12/30
 */
public class LC17 {

    List<String> ans = new ArrayList<>();
    /**
     * 保存单一结果，并用于回溯
     */
    StringBuilder path = new StringBuilder();
    /**
     * 数字对应字母
     */
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        // 空字符串直接返回结果
        if (digits.length() == 0) {
            return ans;
        }
        backtracking(0, digits);
        return ans;
    }

    public void backtracking(int startIndex, String digits) {
        if (path.length() == digits.length()) {
            ans.add(path.toString());
            return;
        }

        // 取每一个数字对应字母字符串 多个集合 `动态字符串做递归` startIndex
        String ch = map.get(digits.charAt(startIndex) + "");
        for (int i = 0; i < ch.length(); i++) {
            path.append(ch.charAt(i));
            // 递归
            System.out.println("递归之前=> " + path);
            backtracking(startIndex + 1, digits);
            // 递归之后撤销操作结果，回溯
            path.deleteCharAt(path.length() - 1);
            System.out.println("递归之后=> " + path);
        }
    }

    public static void main(String[] args) {
        LC17 lc17 = new LC17();
        List<String> stringList = lc17.letterCombinations("234");
        System.out.println(stringList);
    }
}
