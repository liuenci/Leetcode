package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 除数游戏
 * @author: liuenci
 * @create: 2021-09-25 15:32
 **/
public class DivisorGame {

    public static void main(String[] args) {
        DivisorGame divisorGame = new DivisorGame();
        System.out.println(divisorGame.divisorGame(1));
    }

    public boolean divisorGame(int n) {
        // dp[i] 表示在位置 i 处，爱丽丝能否赢得游戏
        boolean[] dp = new boolean[n + 2];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
