package com.cier.solution.StackAndQueue;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    /**
     * 无限循环，每次将成对的括号替换为空字符串
     * 如果替换之前和替换之后的长度一样，说明没有成对的字符串，或者字符串为空字符串，跳出循环体
     * 如果替换之前和替换之后的长度不一样，说明有成对的字符串被替换掉，继续循环替换成对的字符串。
     * 直到替换之前和替换之后的长度一样，跳出循环体为止。
     * 最后判断字符串的长度是否为 0 来判断字符串是否是有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int length;
        while (true) {
            length = s.length();
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
            if (length == s.length()) {
                break;
            }
        }
        return length == 0;
    }

    /**
     * Runtime: 2 ms, faster than 65.35% of Java online submissions for Valid Parentheses.
     * Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Valid Parentheses.
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 如果是左括号就入栈
            if (s.charAt(i) == '{'|| s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            // 如果是右括号就判断栈是否为空，以及栈顶是否和右括号匹配，如果不匹配直接可以返回 false
            if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        // 如果全部匹配，则栈为空，否则不为空
        return stack.isEmpty();
    }
}
