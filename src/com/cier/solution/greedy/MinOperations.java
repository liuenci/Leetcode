package com.cier.solution.greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @program: Leetcode
 * @description: [1827] 最小操作是数组递增
 * @author: liuenci
 * @create: 2022-01-02 22:26
 **/
public class MinOperations {

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        int[] a = {1, 1, 1};
        minOperations.minOperations(a);
    }

    public int minOperations(int[] nums) {
        int count = 0;
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return count;
        }
        for (int i = 1; i < nums.length; i++) {
            int pre = nums[i - 1];
            int cur = nums[i];
            if (cur > pre) {
                continue;
            } else {
                int d = pre - cur + 1;
                count += d;
                nums[i] = cur + d;
            }
        }
        return count;
    }
}
