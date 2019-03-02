package com.cier.company.cvte;

import java.util.Arrays;

public class T2 {
    public int getKthNum(int[] a, int[] b, int k) {
        int[] arr = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        for (int i = a.length,j = 0; i < arr.length; i++,j++) {
            arr[i] = b[j];
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        int[] a = {1,3,5};
        int[] b = {2,4,6};
        System.out.println(t2.getKthNum(a,b,4));
    }
}
