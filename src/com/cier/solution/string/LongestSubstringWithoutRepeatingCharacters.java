package com.cier.solution.string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Runtime: 10 ms, faster than 67.68% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 35.3 MB, less than 99.98% of Java online submissions for Longest Substring Without Repeating Characters.
     *
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
            if (!lookup.contains(s.charAt(end))) {
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

    /**
     * Runtime: 14 ms, faster than 61.28% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 38.2 MB, less than 71.55% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> lookup = new HashMap();
        int l = 0;
        int r = 0;
        //  counter 用来标记当前字串中 unique 字符的数量
        int counter = 0;
        int res = 0;
        while (r < s.length()) {
            if (lookup.get(s.charAt(r)) == null) {
                // 当前遍历到的字符如果不在 map 中需要进行判空处理
                lookup.put(s.charAt(r), 1);
            } else {
                // 否则可以直接 +1
                lookup.put(s.charAt(r), lookup.get(s.charAt(r)) + 1);
            }
            // 如果遍历到之前没有遇到的字符，则 counter++
            if (lookup.get(s.charAt(r)) == 1) {
                counter++;
            }
            // r 指针右移
            r++;
            // counter < r - l 则说明有重复字串出现，否则 counter 等于 r - l
            while (l < r && counter < r - l) {
                lookup.put(s.charAt(l), lookup.get(s.charAt(l)) - 1);
                // 当前 l 指针所代表的字符在 map 中如果为 0 说明 l 指针所代表的字符在 map 中完全被清除
                if (lookup.get(s.charAt(l)) == 0) {
                    counter--;
                }
                // l 指针右移
                l++;
            }
            // 更新最大字串长度
            res = res > (r - l) ? res : (r - l);
        }
        return res;
    }

    /**
     * Runtime: 7 ms, faster than 90.87% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 35.3 MB, less than 99.98% of Java online submissions for Longest Substring Without Repeating Characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        // start 标记当前字串首字符在 s 中对应的索引位置
        int start = 0;
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < length; i++) {
            int temp = -1;
            if (map.get(s.charAt(i)) != null) {
                // 可能当前遍历到的字符是一个全新的字符，没有存在过 map 中，所以需要判空处理
                temp = map.get(s.charAt(i));
            }
            // 找到字串新的起点
            start = start > (temp + 1) ? start : (temp + 1);
            // 更新字串的长度
            res = res > (i - start + 1) ? res : (i - start + 1);
            // 将当前遍历到的字符记录在 map 中
            map.put(s.charAt(i), i);
        }
        return res;
    }
}
