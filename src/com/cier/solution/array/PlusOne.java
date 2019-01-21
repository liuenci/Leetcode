package com.cier.solution.array;
// https://leetcode.com/problems/plus-one/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digits.length; i++){
            stringBuffer.append(digits[i]);
        }
        Long num = Long.valueOf(stringBuffer.toString()) + 1;
        String str = String.valueOf(num);
        int[] nums = new int[str.length()];
        for (int i = 0; i < nums.length; i++){
            nums[i] = str.charAt(i);
        }
        return nums;
    }
}
