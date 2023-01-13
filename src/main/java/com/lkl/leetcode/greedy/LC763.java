package com.lkl.leetcode.greedy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 763. 划分字母区间
 * @author likelong
 * @date 2023/1/13
 */
public class LC763 {

    public List<Integer> partitionLabels(String s) {

        // 我的解法
/*        // 统计各个字符数量
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        // 记录当前片段中出现的字符
        Set<Integer> appear = new LinkedHashSet<>();
        // 双指针
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            // 局部最优：尽可能划分片段出现字符数量少一点 全局最优：保证有尽可能多的片段
            while (j < s.length()) {
                int index = s.charAt(j++) - 'a';
                appear.add(index);
                chars[index]--;

                if (chars[index] == 0) {
                    appear.remove(index);
                }

                if(appear.isEmpty()){
                    // 中断循环
                    break;
                }
            }
            ans.add(j - i);

            // i for循环还要 +1，所以这里要 -1
            i = j - 1;
        }
        return ans;*/

        // 精妙解法：方法论
        // 先统计每个字符的最远下标
        int[] edge = new int[26];
        for (int i = 0; i < s.length(); i++) {
            edge[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new LinkedList<>();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 片段元素最远结束下标
            right = Math.max(right, edge[s.charAt(i) - 'a']);

            // 到片段结束位置 收集结果
            if (i == right){
                ans.add(right - left + 1);
                // 更新左下标
                left = right + 1;
            }

        }
        return ans;
    }

    @Test
    public void test() {
        partitionLabels("ababcbacadefegdehijhklij");
    }
}
