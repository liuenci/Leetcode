package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 斐波拉契数列
 * @author: liuenci
 * @create: 2021-09-23 12:51
 **/
public class Fib {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(5));
    }
}
