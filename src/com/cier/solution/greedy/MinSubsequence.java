package com.cier.solution.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Leetcode
 * @description: [1403] 非递增顺序的最小子序列
 * @author: liuenci
 * @create: 2022-01-02 21:34
 **/
public class MinSubsequence {

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        double avg = Arrays.stream(nums).sum() / 2D;
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            res.add(nums[i]);
            if (sum > avg) {
                return res;
            }
        }
        return res;
    }
}
