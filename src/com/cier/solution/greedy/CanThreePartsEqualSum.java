package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: [1013] 将数组分成和相等的三个部分
 * @author: liuenci
 * @create: 2022-01-01 22:58
 **/
public class CanThreePartsEqualSum {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int div = sum / 3;
        int count = 0;
        int curSum = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            if (curSum == div) {
                count++;
                if (count == 3) {
                    return true;
                }
                curSum = 0;
            }

        }
        return false;
    }

}
