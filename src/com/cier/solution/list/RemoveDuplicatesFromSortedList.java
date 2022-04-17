package com.cier.solution.list;

import com.cier.solution.common.ListNode;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
// 1->1->1->2
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        while (head != null) {
            // 当下一个元素不为空，并且当前元素的值与下一个元素的值相等
            while (head.next != null && head.val == head.next.val) {
                // 则将当前元素指向下一个元素的指针指向下一个元素的再下一个元素。
                head.next = head.next.next;
            }
            // 当前元素没重复，进行下一次判断
            head = head.next;
        }
        return dummy;
    }
}
