package com.cier.solution.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description: 柠檬水找零
 * @author: liuenci
 * @create: 2021-12-22 23:33
 **/
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five++;
            } else if (i == 10) {
                five--;
                ten++;
            } else if (i == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
