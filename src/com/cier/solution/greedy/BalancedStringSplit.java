package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: [1221] 分割平衡字符串
 * @author: liuenci
 * @create: 2022-01-02 21:08
 **/
public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int count = 0;
        int index = 0;
        for (int i = 1; i < s.length(); i = i + 2) {
            String substring = s.substring(index, i + 1);
            if (isBalanced(substring)) {
                count++;
                index = i + 1;
            }
        }
        return count;
    }

    private boolean isBalanced(String s) {
        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCount++;
            } else {
                rCount++;
            }
        }
        return lCount == rCount;
    }
}
