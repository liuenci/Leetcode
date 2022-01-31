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
        // 核心是设置头节点，否则会出现连续相同的节点无法被删除
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 当两个节点的值相等时，只需将当前节点的指针指向下一个相同节点的下一个节点位置
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
