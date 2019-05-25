package com.cier.solution.string;

public class ZigZagConversion {
    /**
     * Runtime: 15 ms, faster than 59.50% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 37.8 MB, less than 96.28% of Java online submissions for ZigZag Conversion.
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        // 只有一行，或者每一行只有一个元素
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuffer[] buffers = new StringBuffer[numRows];
        for (int i = 0; i < buffers.length; i++) {
            buffers[i] = new StringBuffer("");
        }
        int idx = 0;
        int step = 1;
        for (int i = 0; i < s.length(); i++) {
            buffers[idx].append(s.charAt(i));
            // 如果在第一行，就往下走
            if (idx == 0) {
                step = 1;
            }
            // 如果在最后一行，就往上走
            if (idx == numRows - 1) {
                step = -1;
            }
            idx += step;
        }
        String res = "";
        for (int i = 0; i < buffers.length; i++) {
            res += buffers[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        zigZagConversion.convert("abcdefghijklmn",4);
    }
}
