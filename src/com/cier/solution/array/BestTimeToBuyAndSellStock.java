package com.cier.solution.array;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/221860/A-really-easy-understand-java-method
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price:prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(price, minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        bestTimeToBuyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("end");
    }
}
