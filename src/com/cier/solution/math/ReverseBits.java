package com.cier.solution.math;

// https://leetcode-cn.com/problems/reverse-bits/
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        reverseBits.reverseBits(101);
        System.out.println("end");
    }
}
