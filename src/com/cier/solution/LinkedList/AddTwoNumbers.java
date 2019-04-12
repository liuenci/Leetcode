package com.cier.solution.LinkedList;

import com.cier.solution.common.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            result.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = l1.val + l2.val + carry >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        while (l1 != null) {
            result.next = new ListNode((l1.val + carry) % 10);
            carry = l1.val + carry >= 10 ? 1 : 0;
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            result.next = new ListNode((l2.val + carry) % 10);
            carry = l2.val + carry >= 10 ? 1 : 0;
            result = result.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(8);
        node4.next = node5;
        node5.next = node6;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers(node1, node4);
        System.out.println();
    }
}
