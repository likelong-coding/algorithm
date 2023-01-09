package com.lkl.leetcode.backtracking;

/**
 * LC 37. 解数独
 *
 * @author likelong
 * @date 2023/1/5
 */
public class SuDu {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {

        // 双重for循环，处理行和列
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    // 空格才处理，填充数字
                    // 填充的数字 1-9 ，1-9中找有效数字
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            // 满足条件，填充该数字
                            board[row][col] = num;
                            // 递归
                            if (backtracking(board)) {
                                // 找到结果，直接终止
                                return true;
                            }
                            // 否则，回溯
                            board[row][col] = '.';
                        }
                    }

                    // 同一个位置，1-9 九个数都不满足条件，直接返回false
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        // 只能遍历判断

        // 判断同一行是否有相同数字
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // 判断同一列是否有相同数字
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // 3 x 3 宫格内是否有相同数子
        // 开始行列下标
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
