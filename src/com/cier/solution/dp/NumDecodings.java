package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: [91] 解码方法
 * @author: liuenci
 * @create: 2022-02-25 20:13
 **/
public class NumDecodings {

    public int numDecodings(String s) {
        // 为什么这里定义的长度为 s.length() + 1
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            // 当我们只使用了一个字符时，也就是通过 s[i] 进行编码
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // 当我们使用了两个字符时，通过满足 i > 1 (为啥？) 并且要满足组合出来的数字小于等于 26
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
