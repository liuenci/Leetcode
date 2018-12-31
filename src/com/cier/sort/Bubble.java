package com.cier.sort;

public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean hasSorted = false;
        for (int i = 0; i < N && !hasSorted; i++){
            hasSorted = true;
            for (int j = 0; j < N - i - 1; j++){
                if (less(nums[j + 1], nums[j])){
                    hasSorted = false;
                    swap(nums,j,j+1);
                }
            }

        }
    }
}
