package com.lkl.leetcode.everyday;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/12/3
 */
public class Sub1796 {
    public int secondHighest(String s) {
        //我的
//        Set<Character> set = new HashSet<>();
//        for (char ch : s.toCharArray()) {
//            if (ch - 'a' >= 0 && ch - 'a' <= 25) {
//                //字母跳过
//                continue;
//            }
//            set.add(ch);
//        }
//
//        if (set.isEmpty() || set.size() == 1) {
//            return -1;
//        }
//
//        //默认就是小顶堆
//        PriorityQueue<Character> queue = new PriorityQueue<>();
//        for (Character ch : set) {
//            if (queue.size() < 2) {
//                queue.add(ch);
//            } else {
//                if (queue.peek() < ch) {
//                    queue.poll();
//                    queue.add(ch);
//                }
//            }
//        }
//
//        return Character.getNumericValue(queue.poll());

        //正常做法：第一大和第二大
        int max = -1, secondMax = -1;
        for (char ch : s.toCharArray()) {
            if (ch - '0' >= 0 && ch - '0' <= 9) {
                //转成数字
                int digit = ch - '0';
                if (digit > max) {
                    secondMax = max;
                    max = digit;
                } else {
                    if (digit < max && digit > secondMax) {
                        secondMax = digit;
                    }
                }
            }
        }
        return secondMax;
    }

    @Test
    public void test() {
        System.out.println(secondHighest("dfa12321afd"));
    }
}
