package com.lkl.leetcode.stackAndQueue;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/11/28
 */
public class Sub1047 {
    public String removeDuplicates(String s) {
//        //借助栈
//        Stack<Character> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (!stack.isEmpty() && stack.peek().equals(c)) {
//                stack.pop();
//            } else {
//                stack.push(c);
//            }
//        }
//
//        String ans = "";
//        //反转
//        while (!stack.isEmpty()){
//            ans = stack.pop() + ans;
//        }
//        return ans;

        //StringBuilder 充当栈
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(removeDuplicates("abbaca"));
    }
}
