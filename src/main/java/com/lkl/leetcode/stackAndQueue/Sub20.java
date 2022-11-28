package com.lkl.leetcode.stackAndQueue;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author likelong
 * @date 2022/11/28
 */
public class Sub20 {

    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }
        // java8新特性–双括号初始化map
        Map<Character, Character> map = new HashMap<Character, Character>(3) {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else {
                //先出现反括号直接返回false
                if (stack.isEmpty()) {
                    return false;
                }

                //peek返回栈顶元素不删除，pop弹出并返回栈顶元素
                if (!stack.peek().equals(map.get(c))) {
                    //只要栈顶元素跟该元素不匹配直接返回false
                    return false;
                } else {
                    //弹出栈顶元素
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test() {
        System.out.println(isValid("([}}])"));
    }
}
