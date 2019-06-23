package com.cier.solution.array;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/3sum-closest/description/
 */
public class ThreeSumClosest {
    /**
     * Runtime: 6 ms, faster than 50.98% of Java online submissions for 3Sum Closest.
     * Memory Usage: 36.1 MB, less than 99.98% of Java online submissions for 3Sum Closest.
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        // 通过内部 api 进行排序
        Arrays.sort(nums);
        int ret = 1<<30;
        // 通过固定 nums[i]、移动 nums[left] 以及 nums[right] 来逼近目标值 target
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                int xx = ret - target;
                int l = Math.abs(ret - target);
                int r = Math.abs(temp - target);
                if (Math.abs(ret - target) > Math.abs(temp - target)) {
                    ret = temp;
                }
                // temp 小于目标值 target 说明应该向由移动 left 指针，如果大于目标值 target 说明应该向左移动 right 指针
                if (temp <= target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {1,1,-1,-1,3};
        threeSumClosest.threeSumClosest(nums,-1);
    }
}
