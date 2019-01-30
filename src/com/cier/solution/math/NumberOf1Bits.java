package com.cier.solution.math;
// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;

    }

    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        int n = numberOf1Bits.hammingWeight(00000000000000000000000000001011);
        System.out.println(n);
    }
}
