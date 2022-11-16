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
     * 大神们的做法三部曲
     * 1、删除多余空格
     * 2、反转字符串
     * 3、将字符串中每个单词再次反转
     * 得到最后结果
     */
    public String reverseWords1(String s) {
        String newStr = removeExtraSpace(s);
        char[] chars = newStr.toCharArray();

        //双指针寻找字符串中单词
        int j;
        for (int i = 0; i < chars.length; i++) {
            //不以 ' ' 开头，' '结束 刚好是一个单词
            if (chars[i] != ' ') {
                j = i;
                while (j < chars.length) {
                    char ch = chars[j];
                    if (ch == ' ') {
                        break;
                    }
                    j++;
                }
                //此时j指针已经指向' '
                swap(chars, i, j - 1);
                i = j;
            }
        }

        //反转完字符串里的单词后，最后将整个字符串反转就得到想要的结果
        swap(chars, 0 , chars.length - 1);
        return new String(chars);
    }

    /**
     * 移除多余空格
     */
    public String removeExtraSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        //双指针寻找字符串中单词
        int j;
        for (int i = 0; i < chars.length; i++) {
            //不以 ' ' 开头，' '结束 刚好是一个单词
            if (chars[i] != ' ') {
                j = i;
                //最后一个单词后面可能没有空格
                while (j < chars.length) {
                    char ch = chars[j];
                    if (ch == ' ') {
                        break;
                    }
                    j++;
                    sb.append(ch);
                }
                sb.append(" ");
                i = j;
            }
        }

        //去掉最后一个空格
        return sb.substring(0, sb.length() - 1);
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
        System.out.println(reverseWords1("  hello  world    my  name       is"));
    }
}
