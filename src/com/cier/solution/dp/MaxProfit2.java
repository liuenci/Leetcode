package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 买卖股票的最佳收益
 * @author: liuenci
 * @create: 2020-12-03 19:46
 **/
public class MaxProfit2 {

    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2.maxProfit(a));
    }

    // 输入: [7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        // 低点
        int min = prices[0];
        // 收益
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                profit += prices[i] - min;
                min = prices[i];
            } else {
                min = prices[i];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
