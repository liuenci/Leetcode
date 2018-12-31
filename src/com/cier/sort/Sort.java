package com.cier.sort;

public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);
    // 比较此对象与指定对象的顺序。如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
    protected boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }
    // 交换
    protected void swap(T[] a, int i, int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
