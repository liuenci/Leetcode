package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 获取生成数组中的最大值
 * @author: liuenci
 * @create: 2021-09-25 16:25
 **/
public class GetMaximumGenerated {

    public static void main(String[] args) {
        GetMaximumGenerated getMaximumGenerated = new GetMaximumGenerated();
        System.out.println(getMaximumGenerated.getMaximumGenerated(7));
    }

    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
        }
        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
