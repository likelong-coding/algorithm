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

}
