package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [剑指 Offer 52] 两个链表的第一个公共节点
 * @author liuenci
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headA : n1.next;
            n2 = n2 == null ? headB : n2.next;
        }
        return n1;
    }
}
