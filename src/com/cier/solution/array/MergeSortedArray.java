package com.cier.solution.array;
// https://leetcode-cn.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 || n > 0) {
            if (n <= 0) {
                // n <= 0 说明 nums2 中的数字已经全部插入到了 nums1 中
                m--;
            } else if (m <= 0 || nums2[n - 1] > nums1[m - 1]) {
                // 如果 nums2[n - 1] > nums1[m - 1] 就将 nums2[n - 1] 插入到 nums[m + n - 1] 中
                nums1[m + n - 1] = nums2[n - 1];
                // 需要插入的 n 减少 1
                n--;
            } else {
                // 如果 nums2[n - 1] <= nums1[m - 1] 就将 nums1[m - 1] 插入到 nums[m + n - 1] 中
                nums1[m + n - 1] = nums1[m - 1];
                // nums1 待排序的 m 减少 1
                m--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,3,4};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(num1,3,num2,3);
        System.out.println("end");
    }
}
