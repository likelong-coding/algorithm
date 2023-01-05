package com.lkl.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC51
 * n皇后问题
 *
 * @author likelong
 * @date 2023/1/5
 */
public class NQueens {

    /**
     * 最后返回结果
     */
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            // 填充棋盘
            Arrays.fill(c, '.');
        }
        backtracking(0, n, chessboard);
        return ans;
    }

    /**
     * 回溯函数
     *
     * @param row        棋盘高度，每层递归高度不断变化 + 1
     * @param n          棋盘宽度，for循环，控制棋盘宽度
     * @param chessboard 棋盘
     */
    public void backtracking(int row, int n, char[][] chessboard) {
        if (row == n) {
            // 棋盘每一层都处理过了，添加结果
            ans.add(arrayToList(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {

            // 验证合法
            if (isValid(row, col, chessboard)) {
                // 放置皇后
                chessboard[row][col] = 'Q';
                // 递归，棋盘下一行 行 + 1
                backtracking(row + 1, n, chessboard);
                // 回溯 撤销皇后
                chessboard[row][col] = '.';
            }

        }

    }

    /**
     * 棋盘上的某个位置 row 行 col 列
     * 检查当前位置之前的位置即可，后面的还未填充不需关注
     */
    private boolean isValid(int row, int col, char[][] chessboard) {
        // 检查列  检查到当前行为止有没有同列的
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 行和列都不能超过边界

        // 检查45度角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessboard.length; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 行不用检查，因为递归棋盘行会改变，一定不会出现同行皇后
        return true;
    }

    /**
     * 二维数组转List
     *
     * @param chessboard 源二维数组
     */
    public List<String> arrayToList(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            // String.valueOf() 返回char数组参数的字符串表示形式
            list.add(String.valueOf(c));
        }
        return list;
    }

    @Test
    public void test() {
        char[][] chessboard = new char[4][4];
        for (char[] c : chessboard) {
            // 填充棋盘
            Arrays.fill(c, '.');
        }

        System.out.println(arrayToList(chessboard));
        System.out.println("------");
        System.out.println(solveNQueens(3));
    }
}
