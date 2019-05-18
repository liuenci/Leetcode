package com.cier.solution.linklist;

import com.cier.solution.common.ListNode;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return prev;
    }
    // 递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
