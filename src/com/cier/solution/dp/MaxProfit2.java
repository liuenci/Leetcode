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
        int[] a = {7,1,5,3,6,4};
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
}
