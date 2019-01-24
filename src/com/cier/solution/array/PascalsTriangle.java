package com.cier.solution.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                currRow.add(j == 0 || j == i ? 1 : res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            res.add(currRow);
        }
        return numRows == 0 ? new ArrayList<>() : res;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        pascalsTriangle.generate(5);
        System.out.println("end");
    }
}
