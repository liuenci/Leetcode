package com.cier.solution.string;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    /**
     * Runtime: 5 ms, faster than 47.36% of Java online submissions for Integer to Roman.
     * Memory Usage: 36.6 MB, less than 99.99% of Java online submissions for Integer to Roman.
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        String[][] lookup = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        String ret = "";
        for (int i = 0; i < 4; i++) {
            ret = lookup[i][num % 10] + ret;
            num /= 10;
        }
        return ret;
    }
}
