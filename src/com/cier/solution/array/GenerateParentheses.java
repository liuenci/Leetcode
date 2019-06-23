package com.cier.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    /**
     * Runtime: 1 ms, faster than 93.50% of Java online submissions for Generate Parentheses.
     * Memory Usage: 36.4 MB, less than 99.93% of Java online submissions for Generate Parentheses.
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        singleStr(result,"",0,0,n);
        return result;
    }

    private void singleStr(List<String> result, String str,int left, int right, int n){
        if (left == n && right == n) {
            result.add(str);
        }
        if (left < n) {
            singleStr(result,str + "(", left + 1,right,n);
        }
        if (right < left) {
            singleStr(result, str + ")", left, right+1,n);
        }
    }
}
