package com.lkl.leetcode.everyday;

/**
 * @author likelong
 * @date 2022/12/1
 */
public class Sub1779 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        //最小曼哈顿距离
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            int xx = points[i][0], yy = points[i][1];
            if (xx == x || yy == y) {
                int manHa = Math.abs(xx - x) + Math.abs(yy - y);
                if (manHa < min) {
                    min = manHa;
                    ans = i;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : ans;
    }
}
