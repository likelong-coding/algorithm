package com.lkl.leetcode.string;

/**
 * 左旋转字符串
 * @author likelong
 * @date 2022/11/16
 */
public class Offer_58_II {
    public String reverseLeftWords(String s, int n) {
        //前n个元素反转，后面所有元素反转，最后再将整个字符串反转即得到答案
        char[] ch = s.toCharArray();
        swap(ch, 0, n -1);
        swap(ch, n, ch.length - 1);
        swap(ch, 0, ch.length - 1);
        return new String(ch);
    }

    public void swap(char[] ch, int i, int j){
        char temp;
        while(i < j){
            temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
}
