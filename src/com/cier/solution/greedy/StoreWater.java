package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: [LCP 33] 蓄水
 * @author: liuenci
 * @create: 2022-01-02 23:28
 **/
public class StoreWater {

    public int storeWater(int[] bucket, int[] vat) {
        int maxpour = vat[0];
        int n = bucket.length;
        for (int i = 0; i < n; i++) {
            maxpour = Math.max(maxpour, vat[i]);
        }
        if (maxpour == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int pour = maxpour; pour >= 1; pour--) {
            // 表示扩容次数
            int increase = 0;
            for (int i = 0; i < n; i++) {
                int needV = vat[i] % pour == 0 ? vat[i] / pour : vat[i] / pour + 1;
                // 在满足倾倒次数的情况下，需要扩容的次数
                increase += needV - bucket[i] >= 0 ? needV - bucket[i] : 0;
            }
            res = Math.min(increase + pour, res);
        }
        return res;
    }
}
