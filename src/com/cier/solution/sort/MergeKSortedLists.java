package com.cier.solution.sort;

import com.cier.solution.common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description: 合并多个排序队列
 * @author: liuenci
 * @create: 2020-05-28 20:49
 **/
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));

        // 合并列表元素到队列
        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }

        // 把队列中元素添加到了新的链表
        ListNode ans = null;
        while (!queue.isEmpty()) {
            ListNode curr = new ListNode(queue.poll());
            curr.next = ans;
            ans = curr;
        }

        return ans;
    }
}
