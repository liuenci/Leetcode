package com.cier.solution.greedy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: Leetcode
 * @description: [LCS 02] 完成一半题目
 * @author: liuenci
 * @create: 2022-01-02 23:50
 **/
public class HalfQuestions {

    public int halfQuestions(int[] questions) {
        int k = questions.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : questions) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        res = res.stream().sorted().collect(Collectors.toList());
        int count = 0;
        int sum = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            sum += res.get(i);
            count++;
            if (sum >= k) {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {2,1,6,2};
        HalfQuestions halfQuestions = new HalfQuestions();
        halfQuestions.halfQuestions(a);
    }
}
