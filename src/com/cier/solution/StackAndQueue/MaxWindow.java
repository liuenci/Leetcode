package com.cier.solution.StackAndQueue;

import java.util.LinkedList;

//https://leetcode-cn.com/problems/sliding-window-maximum/description/
public class MaxWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return nums;
        }
        if (k == 0) {
            return nums;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] <= nums[i]) {
                linkedList.pollLast();
            }
            linkedList.add(i);
            if (linkedList.peekFirst() == i - k){
                linkedList.pollFirst();
            }
            if (i >= k - 1){
                res[index++] = nums[linkedList.peekFirst()];
            }
        }
        return res;
    }
}
