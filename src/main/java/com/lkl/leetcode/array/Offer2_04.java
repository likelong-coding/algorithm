package com.lkl.leetcode.array;

/**
 * offer2 -> 剑指offer第二版
 * @author likelong
 * @date 2022/11/2
 */
public class Offer2_04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //行
        int m = matrix.length;
        if (m == 0 || matrix == null) {
            return false;
        }
        //列
        int n = matrix[0].length;
        //右上角开始，左小右大
        int row = 0, col = n - 1;
        //横纵下标边界
        while (row <= (m - 1) && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;

    }
}
