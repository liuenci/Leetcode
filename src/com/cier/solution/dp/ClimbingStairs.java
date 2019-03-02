package com.cier.solution.dp;
// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2){
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs2(3));
        System.out.println("end");
    }
}
