package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 最大子序列和
 * @author: liuenci
 * @create: 2020-12-17 19:43
 **/
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums1 = {1};
        System.out.println(maxSubArray.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
