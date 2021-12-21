package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: 验证回文字符串
 * @author: liuenci
 * @create: 2021-12-21 23:18
 **/
public class ValidPalindrome {

    boolean flag = true;

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (flag) {
                    flag = false;
                    return validPalindrome(s.substring(i + 1, j + 1)) || validPalindrome(s.substring(i, j));
                } else {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.validPalindrome("ebcbbececabbacecbbcbe");
    }
}
