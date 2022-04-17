package com.cier.solution.dp;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    /**
     * Runtime: 1 ms, faster than 80.80% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 36.1 MB, less than 99.80% of Java online submissions for Longest Common Prefix.
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int end = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < end && j < strs[i].length() && strs[0].charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            end = j;
        }
        return strs[0].substring(0, end);
    }

    /**
     * Runtime: 1 ms, faster than 80.80% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.7 MB, less than 87.71% of Java online submissions for Longest Common Prefix.
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
