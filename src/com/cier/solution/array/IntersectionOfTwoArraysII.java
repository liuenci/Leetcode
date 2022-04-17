package com.cier.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; i++, j++) {
            if (nums1[i]== nums2[j]){
                res.add(nums1[i]);
            } else if (nums1[i] < nums2[j]) {
                j--;
            } else {
                i--;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
