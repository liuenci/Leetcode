package com.cier.solution.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        Stack<Character> stack = new Stack<>();
        while (!stack.isEmpty() || !list.isEmpty()) {
            if (stack.isEmpty() && !list.isEmpty()) {
                stack.push(list.poll());
            } else if (!stack.isEmpty() && list.isEmpty()) {
                return false;
            } else if (!stack.isEmpty() && !list.isEmpty()) {
                if (map.get(stack.peek()) == list.peek()){
                    stack.pop();
                    list.poll();
                }else {
                    stack.push(list.poll());
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.isValid("{[}]");
        System.out.println("end");
    }
}
