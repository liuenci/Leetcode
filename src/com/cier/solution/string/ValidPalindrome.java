package com.cier.solution.string;
// https://leetcode.com/problems/valid-palindrome

//"A man, a plan, a canal: Panama"

// amanaplanacanalpanama
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i < n && Character.isLetterOrDigit(s.charAt(i)) == false){
                i++;
            }
            while (j >= 0 && Character.isLetterOrDigit(s.charAt(j)) == false) {
                j--;
            }
            if (i == n || j < 0) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }
    public boolean isPalindrom2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (i == j){
                return true;
            }
            if (Character.isLetterOrDigit(s.charAt(i)) == false) {
                i++;
                continue;
            }
            if (Character.isLetterOrDigit(s.charAt(j)) == false) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.isPalindrom2(s);
        System.out.println(validPalindrome);
    }
}
