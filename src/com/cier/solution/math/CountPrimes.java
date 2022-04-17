package com.cier.solution.math;
// https://leetcode-cn.com/problems/count-primes/
public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 质数还有一个特点，就是它总是等于 6x-1 或者 6x+1，其中 x 是大于等于1的自然数。
     * @param n
     * @return
     */
    public boolean isPrimes(int n){
        // 小于等于3 并且大于 1 的数，也就是 2，3 两个数是质数
        if (n <= 3) {
            return n > 1;
        }
        // 不在 6 两侧的数都不是质数
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        // 以 6 为一跳，然后判断 6 两侧的数是否为质数即可
        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
