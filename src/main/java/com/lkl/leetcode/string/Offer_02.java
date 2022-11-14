package com.lkl.leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 替换空格
 *
 * @author likelong
 * @date 2022/11/14
 */
public class Offer_02 {

    public String replaceSpace(String s) {
        //最简洁，调Java api
        //return s.replace(" ", "%20");

        char[] ch = s.toCharArray();
        //记录空格个数
        int count = 0;
        for (char c : ch) {
            if (c == ' ') {
                count++;
            }
        }
        //将原数组扩容
        char[] newCh = Arrays.copyOf(ch, ch.length + count * 2);
        //双指针从后往前遍历，两个指针分别指向新旧数组末尾！！！ 后面的指针追上了前面的指针说明前面已经没有空格了，直接结束循环
        int j = newCh.length - 1;
        for (int i = ch.length - 1; i < j; i--) {
            if (ch[i] != ' ') {
                newCh[j--] = ch[i];
            } else {
                newCh[j] = '0';
                newCh[j - 1] = '2';
                newCh[j - 2] = '%';
                j -= 3;
            }
        }
        return new String(newCh);

        //另一种解法
        //使用StringBuilder拼接
//        StringBuilder sb = new StringBuilder();
//        for(char c : ch){
//            if(c == ' '){
//                sb.append("%20");
//            }else{
//                sb.append(c);
//            }
//        }
//
//        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(replaceSpace("We are happy."));
    }
}
