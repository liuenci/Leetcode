package com.cier.solution.array;

import java.util.HashMap;

/**
 * 两数之和
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
    /**
     * 时间复杂度O(n^2)
     * Runtime: 19 ms, faster than 36.03% of Java online submissions for Two Sum.
     * Memory Usage: 37.5 MB, less than 98.44% of Java online submissions for Two Sum.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 时间复杂度O(n)
     *Runtime: 2 ms, faster than 99.39% of Java online submissions for Two Sum.
     * Memory Usage: 37.3 MB, less than 98.47% of Java online submissions for Two Sum.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
