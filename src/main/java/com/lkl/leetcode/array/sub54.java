package com.lkl.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author likelong
 * @date 2022/10/28
 */
public class sub54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        //边界法：定上下左右四个边界，每处理一条边边界向着相反方向移动
        //直到有边界越界结束循环
        int up = 0, down = m - 1, left = 0, right = n - 1;
        int i, j = 0;
        while (true) {
            //上边界
            for (j = left; j <= right; j++) {
                res.add(matrix[up][j]);
            }
            //上边界向下移
            if (++up > down) break;

            //右边界
            for (i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            //右边界向左移
            if (--right < left) break;

            //下边界
            for (j = right; j >= left; j--) {
                res.add(matrix[down][j]);
            }
            //下边界向上移
            if (--down < up) break;

            //左边界
            for (i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            //左边界向右移
            if (++left > right) break;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};

        System.out.println(new sub54().spiralOrder(matrix));
    }
}
