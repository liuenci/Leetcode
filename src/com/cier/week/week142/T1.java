package com.cier.week.week142;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1 {
    public double[] sampleStats(int[] count) {
        Arrays.sort(count);
        int arraySum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                arraySum++;
            }
        }
        int[] tempArray = new int[count.length - arraySum];
        for (int i = 0,j = arraySum; i < tempArray.length && j < count.length; i++,j++) {
            tempArray[i] = count[j];
        }
        double[] doubles = new double[5];
        // 最小值
        doubles[0] = tempArray[0];
        // 最大值
        doubles[1] = tempArray[tempArray.length - 1];
        // 平均数
        double sum = 0;
        for (int i = 0; i < tempArray.length; i++) {
            sum += tempArray[i];
        }
        doubles[2] = sum / tempArray.length;
        // 中位数
        if (tempArray.length % 2 == 0) {
            doubles[3] = (tempArray[tempArray.length / 2 - 1] + tempArray[tempArray.length / 2]) ;
        } else {
            doubles[3] = (tempArray[tempArray.length / 2]);
        }
        // 众数
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < tempArray.length; i++) {
            if (map.containsKey(tempArray[i])) {
                map.put(tempArray[i],map.get(tempArray[i]) + 1);
            } else {
                map.put(tempArray[i],1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > doubles[4]) {
                doubles[4] = map.get(key);
            }
        }
        return doubles;
    }

    public static void main(String[] args) {
        int[] ints = {0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        T1 t1 = new T1();
        t1.sampleStats(ints);
    }
}
