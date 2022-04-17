package com.cier.solution.array;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
// https://leetcode-cn.com/problems/roman-to-integer/description/
public class RomanToInteger {

    public static int romanToInt(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if (i != s.length() - 1 && s.charAt(i + 1) == 'V') {
                        count += 4;
                        i++;
                    } else if (i != s.length() - 1 && s.charAt(i + 1) == 'X') {
                        count += 9;
                        i++;
                    } else {
                        count += 1;
                    }
                    break;
                case 'V':
                    count += 5;
                    break;
                case 'X':
                    if (i != s.length() - 1 && s.charAt(i + 1) == 'L') {
                        count += 40;
                        i++;
                    } else if (i != s.length() - 1 && s.charAt(i + 1) == 'C') {
                        count += 90;
                        i++;
                    } else {
                        count += 10;
                    }
                    break;
                case 'L':
                    count += 50;
                    break;
                case 'C':
                    if (i != s.length() - 1 && s.charAt(i + 1) == 'D') {
                        count += 400;
                        i++;
                    } else if (i != s.length() - 1 && s.charAt(i + 1) == 'M') {
                        count += 900;
                        i++;
                    } else {
                        count += 100;
                    }
                    break;
                case 'D':
                    count += 500;
                    break;
                case 'M':
                    count += 1000;
                    break;
                default:
                    break;
            }
        }
        return count;
    }

    /**
     * Runtime: 4 ms, faster than 81.66% of Java online submissions for Roman to Integer.
     * Memory Usage: 36 MB, less than 99.95% of Java online submissions for Roman to Integer.
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        String[][] lookup = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        int ret = 0;
        int base = 1000;
        int x = 3;
        int y = 3;
        int pos = 0;
        while (pos < s.length()){
            if (pos + lookup[x][y].length() <= s.length()) {
                boolean wrong = false;
                for (int i = 0; i < lookup[x][y].length(); i++) {
                    if (lookup[x][y].charAt(i) != s.charAt(pos + i)){
                        wrong = true;
                        break;
                    }
                }
                if (!wrong) {
                    pos += lookup[x][y].length();
                    ret += base * y;
                }
            }
            y--;
            if (y == 0) {
                base /= 10;
                x--;
                y = 9;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
