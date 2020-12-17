package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 最大正方形
 * @author: liuenci
 * @create: 2020-12-03 20:33
 **/
public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = {
                {'1', '1', '1'},
                {'1', '1', '0'},
                {'1', '1', '0'}
        };
        System.out.println(maximalSquare.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows == 0 || columns == 0) {
            return 0;
        }

        int result = 0;
        // dp[i][j]表示以第i行和第j列为右下角的正方形的最大边长
        // 递推公式为 dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
        int[][] dp = new int[rows][columns];
        // 初始化列的数据
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';
            result = Math.max(dp[i][0], result);
        }
        // 初始化行的数据
        for (int i = 0; i < columns; i++) {
            dp[0][i] = matrix[0][i] - '0';
            result = Math.max(dp[0][i], result);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }
}
