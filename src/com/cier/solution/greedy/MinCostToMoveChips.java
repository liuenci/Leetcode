package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: [1217] 玩筹码
 * @author: liuenci
 * @create: 2022-01-02 20:45
 **/
public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
