package com.cier.solution.greedy;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @program: Leetcode
 * @description: [1005] K次取反后最大化的数组和
 * @author: liuenci
 * @create: 2022-01-01 22:30
 **/
public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int fnum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                fnum++;
            } else {
                break;
            }
        }
        if (fnum == 0) {
            if (k % 2 == 0) {
                return this.sum(nums);
            } else {
                nums[0] = -nums[0];
                return this.sum(nums);
            }
        } else {
            if (fnum >= k) {
                for (int i = 0; i < k; i++) {
                    nums[i] = -nums[i];
                }
                return this.sum(nums);
            } else {
                for (int i = 0; i < fnum; i++) {
                    nums[i] = -nums[i];
                }
                k = k - fnum;
                Arrays.sort(nums);
                if (k % 2 == 0) {
                    return this.sum(nums);
                } else {
                    nums[0] = -nums[0];
                    return this.sum(nums);
                }
            }
        }
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
