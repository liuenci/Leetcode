package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [83] 删除排序链表中的重复元素
 * @author liuenci
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        ListNode prev = head;
        while (next != null) {
            if (next.val == prev.val) {
                next = next.next;
                prev.next = next;
            } else {
                next = next.next;
                prev = prev.next;
            }
        }
        return head;
    }
}
