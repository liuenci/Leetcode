package com.cier.solution.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Leetcode
 * @description: 无重复字符的最长子串
 * @author: liuenci
 * @create: 2022-03-20 18:37
 **/
public class LengthOfLongestSubstring {

    /**
     * 最土的办法：通过穷举所有的子串，判断所有的子串中没有重复子串的最大长度
     * LeetCode 跑 case 超时了
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int windowSize = s.length();
        while (windowSize > 0) {
            for (int i = 0; i < s.length() && i + windowSize <= s.length(); i++) {
                String substring = s.substring(i, i + windowSize);
                Set<Character> set = new HashSet<>();
                boolean flag = false;
                for (int j = 0; j < substring.length(); j++) {
                    char c = substring.charAt(j);
                    if (set.contains(c)) {
                        flag = true;
                        break;
                    } else {
                        set.add(c);
                    }
                }
                if (!flag) {
                    return set.size();
                }
            }
            windowSize--;
        }
        return 1;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }
}
