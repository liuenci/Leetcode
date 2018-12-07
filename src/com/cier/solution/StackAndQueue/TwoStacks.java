package com.cier.solution.StackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

// https://www.nowcoder.com/questionTerminal/d0d0cddc1489476da6b782a6301e7dec
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        for (int i = 0; i < numbers.length; i++){
            stack.push(numbers[i]);
        }
        while (!stack.isEmpty()){
            int value = stack.pop();
            while (!help.isEmpty() && help.peek() > value){
                stack.push(help.pop());
            }
            help.push(value);
        }
        while (!help.isEmpty()){
            list.add(help.pop());
        }
        return list;
    }

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            Integer value = stack.pop();
            while (!help.isEmpty() && help.peek() < value){
                stack.push(help.pop());
            }
            help.push(value);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
