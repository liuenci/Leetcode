package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [剑指Offer 22] 链表中倒数第k个节点
 * @author liuenci
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        int index = getLength(head) - k;
        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }
}
