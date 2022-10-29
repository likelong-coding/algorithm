package com.lkl.leetcode.array;

import java.util.Stack;

/**
 * @author likelong
 * @date 2022/10/29
 */
public class sub20 {
    public boolean isValid(String s) {
        //第一种解法：
        // while(s.contains("()") || s.contains("{}") || s.contains("[]")){
        //     s = s.replace("()","");
        //     s = s.replace("[]","");
        //     s = s.replace("{}","");
        // }

        // return s.equals("");

        //第二种解法：
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
