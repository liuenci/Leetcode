package com.cier.solution.StackAndQueue;

import java.util.Stack;

//
public class ReverseStack {
    // 拿到最后一个元素并移除
    // 来自《程序员代码面试指南》
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    // 逆序栈
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 通过递归函数逆序一个栈
     * https://www.nowcoder.com/questionTerminal/ba7d7f5d1edf4d1690d66e12e951f6ea
     * @param stack 栈
     * @param top   栈大小
     * @return
     */
    public int[] reverseStackRecursively(int[] stack, int top) {
        // write code here
        if (top == 0) {
            return stack;
        }
        return reverse(stack,0);
    }
    // 通过找到中间位置，将中间位置的两边的值互相交换即可
    public int[] reverse(int[] stack, int position) {
        if (position >= stack.length / 2){
            return stack;
        }
        int end = stack.length - position - 1;
        int temp = stack[position];
        stack[position] = stack[end];
        stack[end] = temp;
        return reverse(stack,position+1);
    }
}
