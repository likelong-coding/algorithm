package com.lkl.sort;

/**
 * @author likelong
 * @date 2022/10/16
 */
public class InsertionSort {

    public static void sort(int[] a) {

        //第一个元素为有序的，从后面元素开始比较插入
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];

            //跟前面元素进行比较
            int j = i - 1;
            //倒序
            while (j >= 0 && a[j] > temp) {
                //找到大于temp的元素，元素向后移一位
                a[j + 1] = a[j];
                j--;
            }
            //最后将待插入元素插入相应位置
            a[j + 1] = temp;
        }
    }

}
