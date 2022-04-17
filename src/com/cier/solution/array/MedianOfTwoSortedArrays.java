package com.cier.solution.array;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 创建新数组存储 nums1 和 nums2
        int[] nums = Arrays.copyOf(nums1, nums1.length + nums2.length);
        // 将 nums2 复制到新创建的数组 nums 中
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        // 数组排序
        Arrays.sort(nums);
        if (nums.length % 2 == 0) {
            // 新数组的长度如果是偶数，则需要找到中间的两个数进行取平均数
            int n1 = nums[nums.length / 2 - 1];
            int n2 = nums[nums.length / 2];
            return (double) (n1 + n2) / 2;
        } else {
            // 否则直接就是最中间的数
            return nums[nums.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        MedianOfTwoSortedArrays sortedArrays = new MedianOfTwoSortedArrays();
        sortedArrays.findMedianSortedArrays2(nums1, nums2);
    }

    public int findKth(int[] A, int[] B, int k) {
        if (A == null || A.length == 0) {
            return B[k - 1];
        }
        if (B == null || B.length == 0) {
            return A[k - 1];
        }
        if (k == 1) {
            return A[0] > B[0] ? A[0] : B[0];
        }
        int a;
        int b;
        if (A.length >= k / 2) {
            a = A[k / 2 - 1];
        } else {
            a = Integer.MAX_VALUE;
        }

        if (B.length >= k / 2) {
            b = B[k / 2 - 1];
        } else {
            b = Integer.MAX_VALUE;
        }
        int[] C = new int[k - k / 2];
        if (a == Integer.MAX_VALUE) {
            System.arraycopy(B, k / 2, C, 0, k - k / 2);
            return findKth(A, C, k - k / 2);
        }
        if (b == Integer.MAX_VALUE) {
            System.arraycopy(A, k / 2, C, 0, k - k / 2);
            return findKth(C, B, k - k / 2);
        }

        if (a < b) {
            System.arraycopy(A, k / 2, C, 0, k - k / 2);
            return findKth(C, B, k - k / 2);
        } else {
            System.arraycopy(B, k / 2, C, 0, k - k / 2);
            return findKth(A, C, k - k / 2);
        }
    }

    public int findKth1(int[] A, int pa, int[] B, int pb, int k) {
        int res = 0;
        int m = 0;
        while (pa < A.length && pb < B.length && m < k) {
            if (A[pa] < B[pb]) {
                res = A[pa];
                pa++;
            } else {
                res = B[pb];
                pb++;
            }
            m++;
        }
        while (pa < A.length && m < k) {
            res = A[pa];
            pa++;
            m++;
        }
        while (pb < B.length && m < k) {
            res = B[pb];
            pb++;
            m++;
        }
        return res;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 1) {
            return findKth1(nums1, 0, nums2, 0, n / 2 + 1);
        } else {
            int smallMedian = findKth1(nums1, 0, nums2, 0, n / 2);
            int biggerMedian = findKth1(nums1, 0, nums2, 0, n / 2 + 1);
            return (double) (smallMedian + biggerMedian) / 2;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int i = 0;
        int j = 0;
        if (n % 2 == 1) {
            double ret = 0;
            for (int k = 0; k < n / 2 + 1; k++) {
                ret = findKth1(nums1, 0,nums2,0, n / 2 + 1);
            }
            return ret;
        } else {
            double ret = 0;
            for (int k = 0; k < n / 2; k++) {
                ret = next(nums1, nums2, i, j);
            }
            return (ret + next(nums1, nums2, i, j)) / 2;
        }
    }

    public double next(int[] nums1, int[] nums2, int i, int j) {
        if (i == nums1.length) {
            return nums2[j++];
        } else if (j == nums2.length) {
            return nums1[i++];
        } else if (nums1[i] < nums2[j]) {
            return nums1[i++];
        } else {
            return nums2[j++];
        }
    }
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        return 0;
    }

}
