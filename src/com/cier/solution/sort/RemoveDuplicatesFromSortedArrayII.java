package com.cier.solution.sort;
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        // 设置一个指针 i 来标志满足要求的元素个数
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // 前两个元素肯定不会重复两次以上
            if (i < 2 || nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
        int[] array = new int[]{1,1,1,2,2,3};
        r.removeDuplicates(array);
    }
}
