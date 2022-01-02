package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: [2078] 两栋颜色不同且距离最远的房子
 * @author: liuenci
 * @create: 2022-01-02 23:13
 **/
public class MaxDistance {

    public int maxDistance(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = max + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    max = Math.max(j - i, max);
                }
            }
        }
        return max;
    }
}
