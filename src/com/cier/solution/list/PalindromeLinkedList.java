package com.cier.solution.list;

import com.cier.solution.common.ListNode;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode node = head;
        ListNode reverseNode = reverse(head);
        while (node != null) {
            if (node.val != reverseNode.val) {
                return false;
            }
            reverseNode = reverseNode.next;
            node = node.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = new ListNode(curr.val);
            temp.next = prev;
            prev = temp;
            curr = curr.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(node1));

    }
}
