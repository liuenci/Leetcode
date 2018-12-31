package com.cier.sort;

public class Selection<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            // min:每次找到的数组的最小值的下标索引
            int min = i;
            // 一旦发现有比 nums[min] 更小的数字，则将 j 赋值给 min
            for (int j = i + 1; j < N; j++){
                if (less(nums[j],nums[min])){
                    min = j;
                }
            }
            swap(nums,i,min);
        }
    }
}
