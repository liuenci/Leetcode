package com.cier.solution.array;

import java.util.Arrays;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp) {
                return temp;
            }
            temp++;
        }
        return temp;
    }

    public int missingNumber2(int[] nums) {
        // 0 1 2 3 5
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (nums.length * (nums.length + 1)) / 2 - sum;
    }
}
