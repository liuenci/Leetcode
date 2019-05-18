package com.cier.solution.string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Runtime: 10 ms, faster than 67.68% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 35.3 MB, less than 99.98% of Java online submissions for Longest Substring Without Repeating Characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int res = 0;
        // HashSet 用来去重
        HashSet lookup = new HashSet();
        while (start < s.length() && end < s.length()) {
            if (!lookup.contains(s.charAt(end))){
                // end 指针所遇到的字符没有在之前遍历的字符中没有遇到过，就放到 HashSet 中
                lookup.add(s.charAt(end));
                // 满足无重复字串时更新最大长度
                res = res > (end - start + 1) ? res : (end - start + 1);
                // end 指针后移
                end++;
            } else {
                // end 指针所遇到的字符没有在之前遍历的字符中遇到过，就从 HashSet 移除
                lookup.remove(s.charAt(start));
                // start 指针后移
                start++;
            }
        }
        return res;
    }
}
