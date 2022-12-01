package com.lkl.leetcode.stackAndQueue;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/12/1
 */
public class Sub71 {

    public String simplifyPath(String path) {

        String[] arr = path.split("/");

        //存放目录
//        Stack<String> stack = new Stack<>();
//        for (String s : arr) {
//            if ("..".equals(s) && !stack.isEmpty()) {
//                stack.pop();
//            }
//
//            if (!".".equals(s) && !"..".equals(s) && !"".equals(s)) {
//                stack.push(s);
//            }
//        }
//        StringBuilder ans = new StringBuilder();
//        while (!stack.isEmpty()) {
//            ans.insert(0, stack.pop());
//            ans.insert(0, "/");
//
//        }
//        if (ans.length() == 0) {
//            return "/";
//        }

        // StringBuilder充当栈
        StringBuilder ans = new StringBuilder();
        for (String s : arr) {
            if ("..".equals(s) && ans.length() > 0) {
                ans.delete(ans.lastIndexOf("/"), ans.length());
            }

            if (!".".equals(s) && !"..".equals(s) && !"".equals(s)) {
                ans.append("/").append(s);
            }
        }

        if (ans.length() == 0) {
            return "/";
        }
        return ans.toString();
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/a/./b/._././c/"));
    }
}
