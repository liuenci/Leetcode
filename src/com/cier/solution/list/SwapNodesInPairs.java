package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * @program: Leetcode
 * @description: 两两交换链表中的节点
 * @author: liuenci
 * @create: 2020-05-28 21:24
 **/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }
}
