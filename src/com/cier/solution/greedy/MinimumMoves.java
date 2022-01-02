package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: [2027] 转换字符串的最少操作次数
 * @author: liuenci
 * @create: 2022-01-02 23:07
 **/
public class MinimumMoves {

    public int minimumMoves(String s) {
        int count = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'X') {
                index = index + 3;
                count++;
            } else {
                index++;
            }
        }
        return count;
    }
}
