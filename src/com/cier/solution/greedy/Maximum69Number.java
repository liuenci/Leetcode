package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: [1323] 6 和 9 组成的最大数字
 * @author: liuenci
 * @create: 2022-01-02 21:29
 **/
public class Maximum69Number {

    public int maximum69Number(int num) {
        return Integer.valueOf(String.valueOf(num).replaceFirst("6", "9"));
    }
}
