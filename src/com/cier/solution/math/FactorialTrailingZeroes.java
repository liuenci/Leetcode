package com.cier.solution.math;

// https://leetcode-cn.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        factorialTrailingZeroes.trailingZeroes(13);
        System.out.println("end");
    }
}
