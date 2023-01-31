package com.lkl.test;

import com.lkl.sort.Bubble;
import com.lkl.sort.InsertionSort;
import com.lkl.sort.Selection;
import com.lkl.sort.Student;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author likelong
 * @date 2022/10/15
 */
public class AllTest {

    /**
     * 比较方法，获取两个元素中的较大值
     */
    public static Comparable getMax(Comparable c1, Comparable c2) {
        int i = c1.compareTo(c2);

        if (i >= 0) {
            return c1;
        }
        return c2;
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(18);
        s1.setUsername("张三");

        Student s2 = new Student();
        s2.setAge(20);
        s2.setUsername("李四");

        System.out.println(getMax(s1, s2));
    }

    @Test
    public void bubbleTest() {
        Integer[] arr = {4, 5, 6, 3, 2, 1};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void selectTest() {
        Integer[] arr = {4, 6, 8, 7, 9, 2, 10, 1};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertTest() {
        int[] a = {4, 3, 2, 10, 12, 1, 5, 6};
        InsertionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 快速排序
     */
    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int left = l;
        int right = r;

        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }

            if (left < right) {
                arr[left] = arr[right];
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                arr[right] = arr[left];
            }

            // 放置pivot到该索引位置
            if (left >= right) {
                arr[left] = pivot;
            }
        }

        quickSort(arr, l, left - 1);
        quickSort(arr, left + 1, r);
    }


    @Test
    public void testQuickSort() {
        int[] arr = new int[]{9, 1, -1, 11, 45, 32, 57, 68, 31, 21, 11, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
