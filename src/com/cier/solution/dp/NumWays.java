package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 传递信息
 * @author: liuenci
 * @create: 2021-10-10 11:16
 **/
public class NumWays {

    public int numWays(int n, int[][] relation, int k) {
        // 定义动态规划的状态 dp[i][j], dp[i][j] 为经过 i 轮传递到编号 j 的玩家的方案数，其中 0 ≤ i ≤k，0≤j<n。
        int[][] dp = new int[k + 1][n];
        // 0 传递到 0 也是一种方案
        dp[0][0] = 1;
        // 通过遍历关系列表，对于(from, to)的关系，第k步到达to的方案数总是由第k-1步到达from的方案数总和。
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0];
                int dst = edge[1];
                // dp[1][2] = dp[0][0] + dp[1][2] = 1;
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        int[][] array = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        System.out.println(numWays.numWays(5, array, 3));
    }
}
