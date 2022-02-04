package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [876] 链表的中间节点
 *
 * @author liuenci
 */
public class MiddleNode {

    /**
     * 获取链表的长度
     *
     * @param head
     * @return
     */
    private int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }

    public ListNode middleNode(ListNode head) {
        int length = getLength(head);
        int index = length / 2;
        return getMiddle(head, index);
    }

    private ListNode getMiddle(ListNode head, int index) {
        ListNode curr = head;
        int i = 0;
        while (i < index) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    public static void main(String[] args) {
        MiddleNode middleNode = new MiddleNode();
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        root.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
//        ListNode node3 = new ListNode(4);
//        node2.next = node3;
        middleNode.middleNode(root);
//        System.out.println(middleNode.getLength(root));
    }


}
