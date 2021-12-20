package com.cier.solution.greedy;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: 数组拆分
 * @author: liuenci
 * @create: 2021-12-20 22:40
 **/
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
