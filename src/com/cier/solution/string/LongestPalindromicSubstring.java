package com.cier.solution.string;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class LongestPalindromicSubstring {
    /**
     * Runtime: 54 ms, faster than 32.14% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 37.8 MB, less than 75.25% of Java online submissions for Longest Palindromic Substring.
     *
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
        if (s.equals("")) {
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
                for (int j = 0; j < Math.min(i + 1, n - i - 1); j++) {
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
        return s.substring(l, r + 1);
    }

    /**
     * Runtime: 31 ms, faster than 46.68% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 37.3 MB, less than 94.69% of Java online submissions for Longest Palindromic Substring.
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        String data = "#";
        for (int i = 0; i < s.length(); i++) {
            data += s.charAt(i);
            data += "#";
        }
        // 半径
        int[] rad = new int[data.length()];
        int id = 0;
        int mx = 0;
        for (int i = 1; i < data.length(); i++) {
            int last = 0;
            if (i > mx) {
                last = i;
            } else {
                if (rad[2 * id - i] < mx - i) {
                    // 2*id-i为中心的最大回文被以id为中心的最大回文所覆盖，没必要继续扩展下去，直接返回
                    rad[i] = rad[2 * id - i];
                    continue;
                } else {
                    last = mx;
                }
            }
            // 继续扩展
            while (last + 1 < data.length() && 2 * i - (last + 1) >= 0 && data.charAt(last + 1) == data.charAt(2 * i - (last + 1))) {
                last++;
            }
            rad[i] = last - i;
            id = i;
            mx = last;
        }
        int left = 0;
        int right = -1;
        for (int i = 0; i < data.length(); i++) {
            // 因为有#的存在，i-rad[i]必是#，也就是偶数下标，i-rad[i]+1对应的必是字母，所以(i-rad[i]+1-1)/2就是原来字母的位置
            int tempLeft = (i - rad[i]) / 2;
            // 同理
            int tempRight = (i + rad[i] - 2) / 2;
            if (tempLeft <= tempRight && right - left < tempRight - tempLeft) {
                left = tempLeft;
                right = tempRight;
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        l.longestPalindrome2("abcdbbfcba");
    }
}
