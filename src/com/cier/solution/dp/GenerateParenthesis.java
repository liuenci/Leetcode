package com.cier.solution.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: Leetcode
 * @description:
 * @author: liuenci
 * @create: 2022-02-21 23:11
 **/
public class GenerateParenthesis {

    /**
     * 哈哈哈哈，完全依靠自己刷出来的 middle 题
     * n = 0 时 result = []
     * n = 1 时 result = ["()"]
     * n = 2 时 result = ["(())", "()()"]
     * 最开始有一个空字符串 a = "", 然后有一个字符串 b = "()"
     * 遍历 a 字符串的每个字符的位置，插入 b 字符串，每一轮会生成一个 List<String> 并且去重得到最终的结果
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        res.add("()");
        int index = 1;
        while (index < n) {
            List<String> newStr = new ArrayList<>();
            for (String temp : res) {
                for (int i = 0; i < temp.length(); i++) {
                    String newString = temp.substring(0, i) + "()" + temp.substring(i, temp.length());
                    newStr.add(newString);
                }
            }
            res = newStr;
            index++;
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));

    }
}
