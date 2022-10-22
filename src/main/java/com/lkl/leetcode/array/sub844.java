package com.lkl.leetcode.array;

import java.util.Stack;

/**
 * 先用栈解决，后续再尝试使用双指针法
 * @author likelong
 * @date 2022/10/22
 */
public class sub844 {
    public static boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    public static String getString(String start) {
        // 栈数据结构 先进后出
        Stack<Character> stack = new Stack<>();
        char[] chars = start.toCharArray();

        for (char ch : chars) {
            if (ch != '#') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    //不判空，弹栈的时候可能会报错
                    stack.pop();
                }
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("#a", "c#d#"));
    }
}
