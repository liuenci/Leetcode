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

    /**
     * 这个比较好理解一点
     * dp[i] 表示走到第 i 个索引的位置的最小花费
     * dp[i] 的最小花费和 前一步的最小花费 与 前两步的最小花费有关
     * 要么是 dp[i - 1] 走一步到达 dp[i]
     * 要么是 dp[i - 2] 走两步到达 dp[i]
     * 再加上踏上 dp[i] 的花费
     *
     * 所以最后一定要判断 dp[i-1] 和 dp[i-2] 的最小值即为问题的答案
     * @param cost
     * @return
     */
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

    public int minCostClimbingStairs1(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        // dp[i] = min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1])
        dp[0] = cost[0];
        dp[1] = Math.min(cost[0], cost[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 1], dp[i - 1] + cost[i]);
        }
        return dp[length - 1];
    }
}
