package com.lkl.leetcode.everyday;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author likelong
 * @date 2022/12/2
 */
public class Sub1769 {

    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        //暴力解法
        char[] ch = boxes.toCharArray();
        for (int i = 0; i < boxes.length(); i++) {
            int sum = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (ch[j] == '1') {
                    sum += Math.abs(j - i);
                }
            }

            ans[i] = sum;
        }

        //记录为'1'元素的下标 效率不高
//        List<Integer> temp = new ArrayList<>();
//        for (int i = 0; i < boxes.length(); i++) {
//            if (boxes.charAt(i) == '1') {
//                temp.add(i);
//            }
//        }
//
//        for (int i = 0; i < boxes.length(); i++) {
//            int op = 0;
//            for (Integer index : temp) {
//                op += Math.abs(i - index);
//            }
//            ans[i] = op;
//        }

        return ans;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(minOperations("001011")));
    }
}
