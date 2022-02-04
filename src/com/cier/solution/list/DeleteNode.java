package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [剑指Offer 18] 删除链表的节点
 * @author liuenci
 */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = head;
        ListNode prev = header;
        while (cur != null) {
            if (cur.val != val) {
                cur = cur.next;
                prev = prev.next;
            } else {
                cur = cur.next;
                prev.next = cur;
            }
        }
        return header.next;
    }
}
