package com.cier.solution.math;
// https://leetcode.com/problems/sqrtx/
public class Sqrtx {

    public int mySqrt(int x) {
        Long r = Long.valueOf(x);
        while (r * r > x){
            r = (r + x / r) / 2;
        }
        return Integer.valueOf(String.valueOf(r));

    }

    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        int x = sqrtx.mySqrt(8);
        System.out.println("end");
    }
}
