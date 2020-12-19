package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 使用最小花费爬楼梯
 * @author: liuenci
 * @create: 2020-12-19 09:38
 **/
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        // 0,0,0,1
        int[] cost = {1, 1, 0, 0};
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        // dp[i] 表示走到第 i 个索引的位置的最小花费
        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }

        // 最后踩在i上或者i-1上，都是完成了这段阶梯，所以取f(n)和f(n-1)中的最小值
        return Math.min(dp[length - 1], dp[length - 2]);
    }
}
