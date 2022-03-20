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
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring1("au"));
    }


    /**
     * 用双指针维护一个滑动窗口，用来剪切子串
     * 不断移动右指针，遇到重复字符，就将左指针移动到重复字符的下一位。
     * 过程中记录窗口的最大值。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int slowIndex = 0;
        int fastIndex = 1;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            String substring = s.substring(slowIndex, fastIndex);
            char temp = s.charAt(i);
            for (int j = 0; j < substring.length(); j++) {
                if (temp == substring.charAt(j)) {
                    max = Math.max(max, fastIndex - slowIndex);
                    slowIndex = slowIndex + j + 1;
                    break;
                }
            }
            fastIndex++;
        }
        return Math.max(max, fastIndex - slowIndex);
    }
}
