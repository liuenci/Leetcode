package com.cier.solution.greedy;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: 分发饼干
 * @author: liuenci
 * @create: 2021-12-20 21:51
 **/
public class FindContentChildren {

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 1};
        FindContentChildren findContentChildren = new FindContentChildren();
        System.out.println(findContentChildren.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < g.length) {
            while (j < s.length) {
                if (s[j] >= g[i]) {
                    count++;
                    j++;
                    break;
                } else {
                    j++;
                }
            }
            i++;
        }
        return count;
    }
}
