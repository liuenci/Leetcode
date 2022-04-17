package com.cier.solution.string;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    /**
     * Runtime: 7 ms, faster than 74.06% of Java online submissions for Palindrome Number.
     * Memory Usage: 36.7 MB, less than 54.39% of Java online submissions for Palindrome Number.
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        // 翻转之后的数字可能超过整型的范围
        long y = 0;
        while ( x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return  temp == y;
    }
}
