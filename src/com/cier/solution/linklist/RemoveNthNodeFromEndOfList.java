package com.cier.solution.linklist;

import com.cier.solution.common.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // cnt 是链表的长度
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        // 算出从后数 n 个从前数第几个
        cnt = cnt - n;
        if (cnt == 0) {
            return head.next;
        } else {
            temp = head;
            // head 已经是第一个了，所以 cnt 减一
            cnt--;
            while (cnt-- != 0) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;
        while (fast.next != null) {
            if (count < n) {
                count++;
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
