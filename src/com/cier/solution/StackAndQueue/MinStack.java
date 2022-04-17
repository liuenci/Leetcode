package com.cier.solution.StackAndQueue;

import java.util.Stack;
// https://leetcode-cn.com/problems/min-stack/description/
public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private Integer min = 0;
    public MinStack() {

    }

    public void push(int x) {
        if (minStack.isEmpty()){
            minStack.push(x);
        }else {
            // 如果更小或两者相等，则 x 也压入 minStack
            if (x <= minStack.peek()){
                minStack.push(x);
            }
        }
        stack.push(x);
    }

    public void pop() {
        if (top() != -1 && top() == minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }
}
