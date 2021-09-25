package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 第 N 个泰波那契数
 * @author: liuenci
 * @create: 2021-09-25 16:17
 **/
public class Tribonacci {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }

    public static void main(String[] args) {
        Tribonacci tribonacci = new Tribonacci();
        System.out.println(tribonacci.tribonacci(25));
    }
}
