package com.cier.company.cvte;

import java.util.Arrays;

public class T1 {

    public int getMonth(int[] months) {
        Arrays.sort(months);
        int num = months[months.length / 2];
        int times = 0;
        for (int i = 0; i < months.length; i++) {
            if (num == months[i]) {
                times++;
            }
        }
        return times > months.length / 2 ? num : -1;
    }

    public static void main(String[] args) {
        int[] months = {1,1,1,1,5,6,7};
        T1 t1 = new T1();
        System.out.println(t1.getMonth(months));
    }
}
