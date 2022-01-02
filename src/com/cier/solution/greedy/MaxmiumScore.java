package com.cier.solution.greedy;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description: [LCP 40] 心算挑战
 * @author: liuenci
 * @create: 2022-01-03 00:24
 **/
public class MaxmiumScore {

    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int sum = 0;
        int index = cards.length - 1;
        while (cnt > 0) {
            sum += cards[index--];
            cnt--;
        }
        if (sum % 2 == 0) {
            return sum;
        }
        for (int i = index; i >= 0; i--) {
            for (int j = index + 1; j < cards.length; j++) {
                sum -= cards[j];
                sum += cards[i];
                if (sum % 2 == 0) {
                    return sum;
                }
                sum += cards[j];
                sum -= cards[i];
            }
        }
        return 0;
    }
}
