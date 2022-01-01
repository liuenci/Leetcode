package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description:
 * @author: liuenci
 * @create: 2021-12-23 22:29
 **/
public class DiStringMatch {

    public int[] diStringMatch(String s) {
        int size = s.length() + 1;
        int[] array = new int[size];
        int max = s.length();
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                array[i] = min;
                min++;
            } else {
                array[i] = max;
                max--;
            }
        }
        array[size - 1] = max;
        return array;
    }
}
