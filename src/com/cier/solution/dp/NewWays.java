package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 青蛙跳台阶问题
 * @author: liuenci
 * @create: 2021-10-08 22:13
 **/
public class NewWays {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}
