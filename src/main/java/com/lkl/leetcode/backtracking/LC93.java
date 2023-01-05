package com.lkl.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * @author likelong
 * @date 2023/1/2
 */
public class LC93 {

    List<String> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 剪枝
        if (s.length() < 4 || s.length() > 12) {
            return ans;
        }
        backtracking(s, 0);
        return ans;
    }

    // 标准回溯模板
    public void backtracking(String s, int start) {
        // 剪枝
        if (path.size() > 4) {
            return;
        }
        // 递归终止条件，切割到最后并且有四个数字
        if (start == s.length() && path.size() == 4) {
            ans.add(toIPString(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // 数字区间范围 [start, i]
            String num = s.substring(start, i + 1);
            if (isIPNum(num)) {
                path.add(num);
                // 递归
                backtracking(s, i + 1);
                // 回溯
                path.remove(path.size() - 1);
            }
        }
    }

    // list 转IP字符串
    public String toIPString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i)).append(".");
            }
        }
        return sb.toString();
    }

    // 判断是否是IP数字
    public boolean isIPNum(String s) {
        // 单个数字 0-9
        if (s.length() == 1) return true;
        if (s.length() > 3) return false;
        // 2-3个数字以0开头，直接返回false
        if (s.charAt(0) == '0') return false;
        if (Integer.parseInt(s) > 255) return false;
        return true;
    }
}
