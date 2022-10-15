package com.lkl.sort;

/**
 * @author likelong
 * @date 2022/10/15
 */
public class Bubble {

    public static void sort(Comparable[] a) {
        //冒泡次数
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    private static boolean greater(Comparable v, Comparable w) {
        //判断v是否大于w
        return v.compareTo(w) > 0;
    }

    /**
     * 两个元素交换
     */
    private static void exch(Comparable[] a, int i, int j) {
        //借助一个临时变量交换元素位置
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
