package com.cier.solution.list;

import com.cier.solution.common.ListNode;

// https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        while (lengthA < lengthB) {
            headB = headB.next;
            lengthB--;
        }
        while (headA == headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
