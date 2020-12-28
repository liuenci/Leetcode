package com.cier.solution.dp;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        // dp[i]表示位置i的最大的回文子串
        // 案例：cbbd
        String[] dp = new String[s.length()];
        dp[0] = s.charAt(0) + "";
        for (int i = 0; i < s.length(); i++) {

        }
        return dp[s.length() - 1];
    }

    /**
     * <h2>跑不过LeetCode的暴力版本</h2>
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int begin = 0;
        int maxLen = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                boolean vaild = vaild(s, i, j);
                if (j - i + 1 > maxLen && vaild) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private boolean vaild(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome1(s));
    }
}
