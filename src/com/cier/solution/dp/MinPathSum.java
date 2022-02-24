package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: [64] 最小路径和
 * @author: liuenci
 * @create: 2022-02-24 21:23
 **/
public class MinPathSum {

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        minPathSum.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {
                dp[0][0] = grid[0][0];
            } else {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (i == 0) {
                dp[0][0] = grid[0][0];
            } else {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (i == 0 || j == 0) {
//                    dp[i][j] =
//                }
//            }
//        }
    }
}
