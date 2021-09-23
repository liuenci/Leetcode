package com.cier.solution.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @program: Leetcode
 * @description: 比特位计数
 * @author: liuenci
 * @create: 2021-09-23 10:17
 **/
public class CountBits {

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        System.out.println(Arrays.stream(countBits.countBits2(5)));
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            String str = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public int[] countBits1(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    public int[] countBits2(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = countOne(i);
        }
        return result;
    }

    private int countOne(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
