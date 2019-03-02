package com.cier.company.cvte;

import java.util.Arrays;

public class T2 {
    /**
     * 最蠢的
     * @param a
     * @param b
     * @param k
     * @return
     */
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

    /**
     * 归并
     * @param a
     * @param b
     * @param k
     * @return
     */
    public int getKthNum1(int[] a, int[] b, int k) {
        int[] arr = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int n = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                arr[n++] = a[i++];
            }else {
                arr[n++] = b[j++];
            }
        }
        while (i < a.length) {
            arr[n++] = a[i++];
        }
        while (j < b.length) {
            arr[n++] = b[j++];
        }
        return arr[k - 1];
    }
    public static void main(String[] args) {
        T2 t2 = new T2();
        int[] a = {1,3,5};
        int[] b = {2,4,6};
        System.out.println(t2.getKthNum1(a,b,4));
    }
}
