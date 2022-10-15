package com.lkl.sort;

/**
 * @author likelong
 * @date 2022/10/15
 */
public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            //记录最小值的索引，每轮都假设第一个元素为最小值
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
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
