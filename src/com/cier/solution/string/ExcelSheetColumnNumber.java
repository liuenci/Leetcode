package com.cier.solution.string;

// https://leetcode-cn.com/problems/excel-sheet-column-number/
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
