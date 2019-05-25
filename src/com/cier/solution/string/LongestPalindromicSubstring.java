package com.cier.solution.string;

/**
 * https://leetcode.com/problems/longest-palindromic-substring
 */
public class LongestPalindromicSubstring {
    /**
     * Runtime: 54 ms, faster than 32.14% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 37.8 MB, less than 75.25% of Java online submissions for Longest Palindromic Substring.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        String res = "";
        // dp[i][j] 用来表示 i 到 j 的字串是否是回文串
        boolean[][] dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                // dp[i][j] 用来判断是否为回文串， j - i + 1 > res.length() 用来判断是否是最长回文串
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
    public String longestPalindrome1(String s) {
        if(s.equals("")){
            return "";
        }
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // 向左最多移动 i 位，向右最多移动 n - 1 - i 位
            for (int j = 0; j < Math.min(i + 1, n - i); j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                if (2 * j + 1 > maxLength) {
                    maxLength = 2 * j + 1;
                    l = i - j;
                    r = i + j;
                }
            }
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                for (int j = 0; j < Math.min(i + 1, n - i - 1); j++ ) {
                    if (s.charAt(i - j) != s.charAt(i + 1 + j)) {
                        break;
                    }
                    if (2 * j + 2 > maxLength) {
                        maxLength = 2 * j + 2;
                        l = i - j;
                        r = i + 1 + j;
                    }
                }
            }
        }
        return s.substring(l,r + 1);
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        l.longestPalindrome("aba");
    }
}
