package com.cier.solution.string;

import java.util.HashMap;

// https://leetcode.com/problems/valid-anagram/discuss/224783/Java-O(n)-time-complexity-and-space-comparing-HashMaps
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = convert(s);
        HashMap<Character, Integer> map2 = convert(t);
        return map1.equals(map2);
    }

    public HashMap<Character, Integer> convert(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        return map;
    }
}
