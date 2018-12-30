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
// https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger {

    public static int romanToInt(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if (i != s.length() - 1 && s.charAt(i+1) == 'V') {
                        count += 4;
                        i++;
                    } else if (i != s.length() - 1 && s.charAt(i+1) == 'X') {
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
                    if (i != s.length() - 1 && s.charAt(i+1) == 'L') {
                        count += 40;
                        i++;
                    } else if (i != s.length() - 1 && s.charAt(i+1) == 'C') {
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
                    if (i != s.length() - 1 && s.charAt(i+1) == 'D') {
                        count += 400;
                        i++;
                    } else if (i != s.length() - 1 && s.charAt(i+1) == 'M') {
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

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
