package com.cier.sort;

public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] aux;

    protected void merge(T[] nums, int l, int m, int h){
        int i = l;
        int j = m + 1;

        for (int k = l; k <= h; k++) {
            aux[k] = nums[k];
        }

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(nums[j]) <= 0) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}
