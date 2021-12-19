package com.cier.solution.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: Leetcode
 * @description: 最长回文串
 * @author: liuenci
 * @create: 2021-12-19 12:00
 **/
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<Character> ch = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            ch.add(s.charAt(i));
        }
        Map<Character, Long> collect = ch.stream().collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        int maxSingle = 0;
        int count = 0;
        for (Map.Entry<Character, Long> entry : collect.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                count += entry.getValue();
            } else {
                maxSingle = Math.max(maxSingle, entry.getValue().intValue());
            }
        }
        count += maxSingle;
        return count;
    }
}
