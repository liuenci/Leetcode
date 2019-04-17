package com.cier.solution.sort;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 第一个数肯定不是重复的数，并且作为一个指针来计算不重复的数的个数
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // 如果不是重复的数，就将指针 i 后移,同时将不重复的元素分配到指针 i 目前到达的位置
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        // i+1 是因为需要加上第一个不重复的数
        return i + 1;
    }

    public int removeDuplicates2(int[] nums) {
        // len 初始化为 nums 的长度，当发现重复的元素则会递减。
        int len = nums.length;
        int i = 0;
        while (i < len - 1) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < len - 1; j++) {
                    // 发现重复的元素则会将后面的元素依次前移一位
                    nums[j] = nums[j + 1];
                }
                len--;
            }else {
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        removeDuplicatesFromSortedArray.removeDuplicates2(nums);
        System.out.println("end");
    }
}
