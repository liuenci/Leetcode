package com.cier.solution.dp;

/**
 * @program: Leetcode
 * @description: 按摩师
 * @author: liuenci
 * @create: 2021-10-08 22:35
 **/
public class Message {

    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int c = Math.max(a + nums[2], b);
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return c;
    }
}
