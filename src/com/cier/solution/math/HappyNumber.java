package com.cier.solution.math;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/happy-number
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int next = 0;
            do {
                next += (n % 10) * (n % 10);
            } while ((n /= 10) > 0);
            n = next;
        }
        return n == 1;
    }
}
