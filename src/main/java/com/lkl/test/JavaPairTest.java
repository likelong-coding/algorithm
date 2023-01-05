package com.lkl.test;

import javafx.util.Pair;

/**
 * @author likelong
 * @date 2023/1/5
 */
public class JavaPairTest {

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(1, "One");
        Integer key = pair.getKey();
        String value = pair.getValue();
        System.out.println("key: " + key + " -> value: " + value);
    }
}
