package com.cier.solution.string;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public char firstUniqChar1(String s) {
        // set => 存储偶数字符
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            // 假设每一次遇到的都是奇数字符
            char c = s.charAt(i);
            if (set.contains(c)) {
                continue;
            }

            // 因为当前字符已存在，所以从当前字符的下一位开始遍历
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                char c1 = s.charAt(j);
                if (c == c1) {
                    count++;
                }
            }

            // 当前字符为奇数时，则确定是第一个奇数字符，否则加入到偶数 set 中
            if (count % 2 == 1) {
                return c;
            } else {
                set.add(c);
            }
        }
        return 0;
    }

    public char firstUniqChar2(String s) {
        Map<Character, Integer> cToIndexMapping = new HashMap<>();
        Integer[] index = new Integer[s.length()];
        Integer step = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cToIndexMapping.containsKey(c)) {
                Integer idx = cToIndexMapping.get(c);
                index[idx]++;
            } else {
                index[step]++;
                cToIndexMapping.put(c, step);
                step++;
            }
        }
        int idx = 0;
        for (int i = 0; i < index.length; i++) {
            if (index[i] % 2 == 1) {
                idx = i;
                break;
            }
        }
        for (Map.Entry<Character, Integer> entry :cToIndexMapping.entrySet()) {
            if (entry.getValue() == idx) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
