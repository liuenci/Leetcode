package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 判断子序列
 * @author: liuenci
 * @create: 2020-12-18 18:53
 **/
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence subsequence = new IsSubsequence();
        System.out.println(subsequence.isSubsequence2("abc", "ahbgdc"));
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 输入：s = "aa", t = "ba"
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean flag = false;
            for (int j = index; j < t.length(); j++) {
                if (t.charAt(j) == c) {
                    index = j + 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int lowIndex = 0;
        int highIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (lowIndex > s.length() - 1) {
                return true;
            }
            if (s.charAt(lowIndex) == t.charAt(highIndex)) {
                lowIndex++;
            }
            highIndex++;
        }
        return lowIndex > s.length() - 1;
    }
}