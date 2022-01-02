package com.cier.solution.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: Leetcode
 * @description: [1710] 卡车上的最大单元树
 * @author: liuenci
 * @create: 2022-01-02 21:45
 **/
public class MaximumUnits {

    public static void main(String[] args) {
        int[][] bn = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        MaximumUnits maximumUnits = new MaximumUnits();
        maximumUnits.maximumUnits(bn, 10);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int sum = 0;
        for (int[] box : boxTypes) {
            Integer key = box[1];
            Integer value = box[0];
            int min = Math.min(value, truckSize);
            sum += key * min;
            truckSize = truckSize - min;
            if (sum == 0) {
                return sum;
            }
        }
        return sum;
    }
}