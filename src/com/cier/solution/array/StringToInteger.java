package com.cier.solution.array;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int start = 0;
        // 过滤前置空格
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        // 判断符号
        int sign = 1;
        if (start < str.length() && str.charAt(start) == '-') {
            sign = -1;
            start++;
        } else if (start < str.length() && str.charAt(start) == '+') {
            sign = 1;
            start++;
        }

        int ret = 0;
        while (start < str.length()) {
            if (str.charAt(start) <= '9' && str.charAt(start) >= '0') {
                if (sign > 0) {
                    // 判断越界
                    if (ret > 214748364 || (ret == 214748364 && str.charAt(start)> '7')) {
                        return 2147483647;
                    }
                    ret = ret * 10 + (str.charAt(start) - '0');
                } else {
                    // 判断越界
                    if (ret < -214748364 || (ret == -214748364 && str.charAt(start) > '8')) {
                        return -2147483648;
                    }
                    ret = ret * 10 - (str.charAt(start) - '0');
                }
            } else {
                break;
            }
            start++;
        }
        return ret;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        int end = stringToInteger.myAtoi("-91283472332");
        System.out.println(end);
    }
}
