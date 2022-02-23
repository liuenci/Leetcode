package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: [62] 不同路径
 * @author: liuenci
 * @create: 2022-02-23 23:00
 **/
public class UniquePaths {

    /**
     * 1 * 1 时 路径 = 1
     * 1 * 2 时 路径 = 1
     * 2 * 1 时 路径 = 1
     * 2 * 2 时 路径 = 2
     * 2 * 3 时 路径 = 3
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        // 这里为什么是 m - 1 和 n - 1 是因为数组的长度是从 0 开始的
        return dp[m - 1][n - 1];
    }
}
