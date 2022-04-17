package com.cier.solution.string;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {
    /**
     * Runtime: 3 ms, faster than 65.39% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 37.2 MB, less than 95.26% of Java online submissions for Regular Expression Matching.
     * @param s
     * @param p
     * @param i 表示 s 现在的位置
     * @param j 表示 p 现在的位置
     * @return 该函数返回 s[0..i] 能否和 p[0..i] 匹配
     */
    public boolean isMatch(String s, String p, int i, int j) {
        if (i == -1 && j == -1) {
            return true;
        }
        if (i == -1) {
            if (p.charAt(j) == '*') {
                return isMatch(s, p, i, j - 2);
            } else {
                return false;
            }
        }
        if (j == -1) {
            return false;
        }
        // 处理 .*
        if (j > 0 && p.charAt(j - 1) == '.' && p.charAt(j) == '*') {
            return isMatch(s, p, i - 1, j) || isMatch(s, p, i, j - 2);
        }
        // 处理 a*
        if (j > 0 && p.charAt(j) == '*') {
            if (s.charAt(i) == p.charAt(j - 1)) {
                return isMatch(s, p, i - 1, j) || isMatch(s, p, i, j - 2);
            } else {
                return isMatch(s, p, i, j - 2);
            }
        }
        // 处理.
        if (p.charAt(j) == '.') {
            return isMatch(s, p, i - 1, j - 1);
        }
        // 处理a
        if (p.charAt(j) == s.charAt(i)) {
            return isMatch(s, p, i - 1, j - 1);
        } else {
            return false;
        }
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, s.length() - 1, p.length() - 1);
    }

    public boolean isMatch1(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                if (i == 0) {
                    if (j >= 2 && p.charAt(j - 1) == '*') {
                        dp[i][j]= dp[i][j - 2];
                    }
                    continue;
                }
                if (j == 0) {
                    continue;
                }
                // 处理.*
                if (j >= 2 && p.charAt(j - 2) == '.' && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    continue;
                }
                // 处理 a*
                if (j >= 2 && p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                    continue;
                }
                // 处理.
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 处理a
                if (p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }

        }
        return dp[s.length()][p.length()];
    }
}
