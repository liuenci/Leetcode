package com.cier.solution.greedy;

import java.util.List;

/**
 * @program: Leetcode
 * @description: [1903] 字符串中的最大奇数
 * @author: liuenci
 * @create: 2022-01-02 22:37
 **/
public class LargestOddNumber {

    public String largestOddNumber(String num) {
        int index = num.length() - 1;
        while (index != -1 && !"".equals(num.substring(index, index + 1)) && Integer.valueOf(num.substring(index, index + 1)) % 2 == 0) {
            index--;
        }
        return num.substring(0, index + 1);
    }

    public static void main(String[] args) {
        LargestOddNumber largestOddNumber = new LargestOddNumber();
        largestOddNumber.largestOddNumber("4206");
    }
}
