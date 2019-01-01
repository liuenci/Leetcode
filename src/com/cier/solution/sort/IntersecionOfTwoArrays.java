package com.cier.solution.sort;

import java.util.*;

public class IntersecionOfTwoArrays {
    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0 || n == 0) {
            return new int[0];
        }
        int i = 0;
        int j = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < m && j < n){
            if (nums1[i] == nums2[j]) {
                set.add((nums1[i]));
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] array = new int[set.size()];
        int s = 0;
        for (Integer integer : set) {
            array[s] = integer;
            s++;
        }
        return array;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++){
            if (set.remove(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
