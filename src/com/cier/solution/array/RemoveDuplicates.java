package com.cier.solution.array;

/**
 * @program: Leetcode
 * @description: 删除排序数组中的重复项
 * @author: liuenci
 * @create: 2020-12-19 11:33
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
