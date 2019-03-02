package com.cier.solution.math;
// https://leetcode.com/problems/power-of-three/
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
