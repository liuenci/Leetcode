package com.cier.solution.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * [22] 括号生成
 *
 * @author liuenci
 */
public class GenerateParenthesis {

    /**
     * 尝试推导动态转移方程
     * n=0 return []
     * n=1 return ["()"]
     * n=2 return ["()()","(())"]
     * n=3 return ["()()()","()(())","(())()","(()())","((()))"]
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        } else if (n == 1) {
            res.add("()");
            return res;
        } else {
            res.add("()");
            for (int i = 0; i <= n - 1; i++) {
                List<String> sub1 = new ArrayList<>();
                for (String sub : res) {

                }
            }
            return res;
        }
    }
}
