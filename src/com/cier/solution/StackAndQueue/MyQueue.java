package com.cier.solution.StackAndQueue;

import java.util.Stack;

// https://leetcode-cn.com/problems/implement-queue-using-stacks/description/
public class MyQueue {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        while (!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
        inStack.push(x);
    }

    public int pop() {
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()){
            if (inStack.isEmpty()){
                return -1;
            }
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outStack.empty() && inStack.empty();
    }
}
