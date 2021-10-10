package com.cier.solution.dp;

import javax.swing.plaf.IconUIResource;

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
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs.minCostClimbingStairs4(cost));
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

    public int minCostClimbingStairs2(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }


    /**
     * 假设数组 \textit{cost}cost 的长度为 nn，则 nn 个阶梯分别对应下标 00 到 n-1n−1，楼层顶部对应下标 nn，问题等价于计算达到下标 nn 的最小花费。可以通过动态规划求解。
     *
     * 创建长度为 n+1n+1 的数组 \textit{dp}dp，其中 \textit{dp}[i]dp[i] 表示达到下标 ii 的最小花费。
     *
     * 由于可以选择下标 00 或 11 作为初始阶梯，因此有 \textit{dp}[0]=\textit{dp}[1]=0dp[0]=dp[1]=0。
     *
     * 当 2 \le i \le n2≤i≤n 时，可以从下标 i-1i−1 使用 \textit{cost}[i-1]cost[i−1] 的花费达到下标 ii，或者从下标 i-2i−2 使用 \textit{cost}[i-2]cost[i−2] 的花费达到下标 ii。为了使总花费最小，\textit{dp}[i]dp[i] 应取上述两项的最小值，因此状态转移方程如下：
     *
     * \textit{dp}[i]=\min(\textit{dp}[i-1]+\textit{cost}[i-1],\textit{dp}[i-2]+\textit{cost}[i-2])
     * dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])
     *
     * 依次计算 \textit{dp}dp 中的每一项的值，最终得到的 \textit{dp}[n]dp[n] 即为达到楼层顶部的最小花费。
     * @param cost
     * @return
     */
    public int minCostClimbingStairs3(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

    public int minCostClimbingStairs4(int[] cost) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 2; i <= cost.length; i++) {
            c = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = c;
        }
        return c;
    }
}
