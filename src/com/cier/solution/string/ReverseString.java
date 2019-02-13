package com.cier.solution.string;
// https://leetcode.com/problems/reverse-string/
public class ReverseString {

    // ["h","e","l","l"]
    public void reverseString(char[] s) {
        int mid = s.length / 2;
        if (mid % 2 == 0) {
            for (int i = 0; i < mid; i++) {
                char temp = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = temp;
            }
        } else {
            for (int i = 0; i < mid; i++) {
                char temp = s[i];
                s[i] = s[2 * mid - i];
                s[2 * mid - i] = temp;
            }
        }
    }
}
