package com.cier.solution.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] lookup = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        // 用队列来保存满足要求的字符串
        Queue<String> queue = new LinkedList();
        queue.add("");
        for (int i = 0; i < digits.length(); i++) {
            // - '0' 为了转化为整型
            String letter = lookup[digits.charAt(i) - '0'];
            int n = queue.size();
            for (int j = 0; j < n; j++) {
                // 弹出队列头
                String s = queue.poll();
                for (int k = 0; k < letter.length(); k++) {
                    // 每次入队满足要求的字符串
                    queue.add(s + letter.charAt(k));
                }
            }
        }
        List<String> ret = new ArrayList<>();
        // 将满足条件的字符串逐步出队
        while (!queue.isEmpty()) {
            ret.add(queue.poll());
        }
        return ret;
    }
}
