package com.cier.solution.tree;

import java.util.PriorityQueue;

/**
 * @program: Leetcode
 * @description: 数据流中的第 K 大元素
 * @author: liuenci
 * @create: 2021-12-12 11:47
 **/
public class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int searchKey = 0;

    public KthLargest(int k, int[] nums) {
        searchKey = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > searchKey) {
            queue.poll();
        }
        return queue.peek();
    }
}
