package com.cier.solution.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 杨辉三角
 * @author: liuenci
 * @create: 2021-09-21 17:30
 **/
public class YanghuiTriangle2 {

    public static void main(String[] args) {
        YanghuiTriangle2 yanghuiTriangle = new YanghuiTriangle2();
        System.out.println(yanghuiTriangle.getRow(3));

    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] array = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i < array.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
                list.add(array[i][j]);
            }
            result.add(list);
        }
        return result.get(rowIndex);
    }
}
