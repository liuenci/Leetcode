package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: [97] 交错字符串
 * @author: liuenci
 * @create: 2022-02-25 22:06
 **/
public class IsInterleave {

    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        System.out.println(isInterleave.isInterleave("ab", "ba", "abba"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    public boolean isInterleave(String s1, String s2, String s3, int a, int b, int c) {
        if (c >= s3.length() || (a == s1.length() && s2.substring(b, s2.length()).equals(s3.substring(c, s3.length()))) || (b == s2.length() && s1.substring(a, s1.length()).equals(s3.substring(c, s3.length())))) {
            return true;
        } else if (a == s1.length() || b == s2.length()) {
            return false;
        }

        if (s1.charAt(a) == s3.charAt(c) && s2.charAt(b) == s3.charAt(c)) {
            return isInterleave(s1, s2, s3, a + 1, b, c + 1) || isInterleave(s1, s2, s3, a, b + 1, c + 1);
        } else if (s1.charAt(a) == s3.charAt(c)) {
            return isInterleave(s1, s2, s3, a + 1, b, c + 1);
        } else if (s2.charAt(b) == s3.charAt(c)) {
            return isInterleave(s1, s2, s3, a, b + 1, c + 1);
        } else {
            return false;
        }
    }
}
