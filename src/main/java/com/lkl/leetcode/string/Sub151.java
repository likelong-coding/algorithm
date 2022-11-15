package com.lkl.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * @author likelong
 * @date 2022/11/15
 */
public class Sub151 {

    /***
     * 我的做法（应该也还好吧）
     */
    public String reverseWords(String s) {
        //先将字符串分割 分割后可能包含 "" 或者 " "
        String[] strings = s.split(" ");
        int index = 0;
        //将单词移到数组前端
        for (String string : strings) {
            if ("".equals(string) || " ".equals(string)) {
                continue;
            }
            strings[index++] = string;
        }

        //双指针法反转单词
        int l = 0, r = index - 1;
        String temp;
        while (l < r) {
            temp = strings[l];
            strings[l] = strings[r];
            strings[r] = temp;
            l++;
            r--;
        }
        //拼接出最后结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                sb.append(strings[i]);
                break;
            }
            sb.append(strings[i]).append(" ");

        }
        return sb.toString();
    }

    /**
     * 大神们的做法
     * 1、删除多余空格
     * 2、反转字符串
     * 3、将字符串中每个单词再次反转
     * 得到最后结果
     */
    public String reverseWords1(String s) {

        return null;
    }

    /**
     * 移除多余空格
     */
    public String removeExtraSpaces(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        //
        int start = 0;
        int end;
        for (int i = 0; i < chars.length; i++) {

        }

        return null;
    }

    /**
     * 字符串反转
     */
    public void swap(char[] arr, int i, int j) {
        char temp;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test() {
        System.out.println(reverseWords("  hello world  "));
    }
}
