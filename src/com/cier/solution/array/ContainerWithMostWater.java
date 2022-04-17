package com.cier.solution.array;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
    /**
     * Runtime: 3 ms, faster than 54.04% of Java online submissions for Container With Most Water.
     * Memory Usage: 39.4 MB, less than 96.47% of Java online submissions for Container With Most Water.
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ret = min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            ret = max(ret, min(height[left],height[right]) * (right - left));
        }
        return ret;
    }
    public int max(int a, int b) {
        return a > b ? a : b;
    }
    public int min(int a, int b) {
        return a < b ? a : b;
    }
}
