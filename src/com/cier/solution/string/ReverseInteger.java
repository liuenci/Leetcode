package com.cier.solution.string;

// https://leetcode.com/problems/reverse-integer/description/
public class ReverseInteger {

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE && pop > 7)){
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE && pop < -8)){
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println("end");
        System.out.println(Math.pow(-2,31));
        System.out.println(Math.pow(2,31) - 1);
    }
}
