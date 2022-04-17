package com.cier.solution.array;
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfix = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfix += prices[i] - prices[i - 1];
            }
        }
        return maxProfix;
    }
}
