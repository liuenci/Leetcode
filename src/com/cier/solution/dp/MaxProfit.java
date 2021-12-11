package com.cier.solution.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: Leetcode
 * @description: 股票的最大收益
 * @author: liuenci
 * @create: 2020-12-02 20:07
 **/
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] a = {7,1,5,3,6,4};
        System.out.println(maxProfit.maxProfit4(a));

    }

    /**
     * 弱智版本
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length && j >= i; j++) {
                int sub = prices[j] - prices[i];
                if (sub > result) {
                    result = sub;
                }
            }
        }
        return result;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // 创建两个数组，一个记录每次卖出的最大收益，一个记录每次买入的最大收益
        int[] sell = new int[n];
        int[] buy = new int[n];
        // 初始化第一天收益
        sell[0] = 0;
        buy[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 第i天卖出收益 = max(第i-1天卖出收益,第i-1天买入收益+当天股价)
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            // 第i天买入收益 = max(第i-1天买入收益,-当天股价)
            buy[i] = Math.max(buy[i - 1], -prices[i]);
        }
        return Math.max(sell[n - 1], buy[n - 1]);
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 记录股票的最低点
        int min = Integer.MAX_VALUE;
        // 记录股票的最大收益
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 记录买入的最大收益
        int maxBuyProfit = prices[0];

        // 记录卖出的最大收益
        // 卖出的最大收益 = 当天股价 - 历史的最低点
        int maxSellProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxBuyProfit = Math.min(maxBuyProfit, prices[i]);
            int profit = prices[i] - maxBuyProfit;
            maxSellProfit = Math.max(maxSellProfit, profit);
        }
        return maxSellProfit;
    }

    /**
     * 买卖股票的最好时机
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        // dp 思想来考虑
        // dp[0] = 0;
        // dp[1] = max{dp[0], array[1] - array[0]}
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return dp[dp.length - 1];
    }
}
