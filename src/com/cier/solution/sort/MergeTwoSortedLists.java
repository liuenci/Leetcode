package com.cier.solution.sort;

import com.cier.solution.common.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode prev = result;
        // 遍历两个链表，每次比较链表头的大小，每次让较小值添加到 dummy 的后面，并且让较小值所在的链表后移一位
        while (l1!= null && l2!= null) {
            if (l1.val >= l2.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        // 会出现一条链表遍历完另外一条链表没遍历完的情况，需要将没遍历的链表添加到结果链表中
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return result.next;
    }
}
