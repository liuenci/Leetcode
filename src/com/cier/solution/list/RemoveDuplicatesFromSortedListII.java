package com.cier.solution.list;

import com.cier.solution.common.ListNode;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
// 1 2 3 3 4 4 5
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // dummy 指向不重复的 head 结点
        ListNode dummy  = new ListNode(0);
        // cur 指向当前结点
        ListNode cur  = dummy;
        // prev 指向前一个结点
        ListNode prev  = null;
        while (head != null) {
            if ((head.next == null || head.val != head.next.val) && (prev == null || prev.val != head.val)){
                cur.next = head;
                cur = cur.next;
            }
            prev = head;
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        // [1,2,3,3,4,4,5]
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        r.deleteDuplicates(node1);
    }
}
