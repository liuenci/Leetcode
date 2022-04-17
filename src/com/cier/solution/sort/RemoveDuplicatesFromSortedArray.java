package com.cier.solution.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * Runtime: 1 ms, faster than 99.23% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 38.7 MB, less than 99.96% of Java online submissions for Remove Duplicates from Sorted Array.
     * @param nums
     * @return
     */
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

    /**
     * 由于题目规定不能创建新的空间，所以不能使用类似 Set 进行去重。
     * 同时 Java 的数组没有 pop 的方法，因此我们考虑每次发现有重复的元素时，就将数组后面的数全部前移一位。
     * 这样的缺陷就是比较慢了。
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        // len 用来计算最终的数组中不重复的数值
        int len = nums.length;
        // i 指针用来计算不重复的数个数
        int i = 0;
        while (i < len - 1) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < len - 1; j++) {
                    // 发现重复的元素则会将后面的元素依次前移一位
                    nums[j] = nums[j + 1];
                }
                len--;
            } else {
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
