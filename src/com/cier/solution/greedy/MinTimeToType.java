package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: [1974] 使用特殊打字机键入单词的最少时间
 * @author: liuenci
 * @create: 2022-01-02 22:47
 **/
public class MinTimeToType {

    public static void main(String[] args) {
        MinTimeToType minTimeToType = new MinTimeToType();
        minTimeToType.minTimeToType("zjpc");
    }

    public int minTimeToType(String word) {
        int c = 27;
        int index = 1;
        int sum = Math.min(Math.abs(word.charAt(0) - 'a') % c, (c - 1 - Math.abs(word.charAt(0) - 'a')) % c) + 1;
        while (index < word.length()) {
            sum += Math.min(Math.abs(word.charAt(index) - word.charAt(index - 1)) % c, (c - 1 - Math.abs(word.charAt(index) - word.charAt(index - 1))) % c) + 1;
            index++;
        }
        return sum;
    }
}
