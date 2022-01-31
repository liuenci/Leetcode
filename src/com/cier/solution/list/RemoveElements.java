package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [203] 移除链表元素
 *
 * @author liuenci
 */
public class RemoveElements {

    /**
     * 移除链表元素
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return header.next;
    }

    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(1);
        root.next = node1;
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        removeElements.removeElements(root, 1);
    }
}
