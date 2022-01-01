package com.cier.solution.greedy;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: [976] 三角形的最大周长
 * @author: liuenci
 * @create: 2022-01-01 22:20
 **/
public class LargestPerimeter {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; i--) {
            int i1 = nums[i + 2];
            int i2 = nums[i + 1];
            int i3 = nums[i];
            if (i1 + i2 > i3 && Math.abs(i1 - i2) < i3) {
                return i1 + i2 + i3;
            }
        }
        return 0;
    }
}
