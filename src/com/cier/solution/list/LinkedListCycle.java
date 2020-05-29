package com.cier.solution.list;

import com.cier.solution.common.ListNode;

import java.util.HashSet;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head!= null) {
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }
    public boolean hasCycle2(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2 != null) {
            n1 = n1.next;
            if (n2.next != null) {
                n2 = n2.next.next;
            } else {
                break;
            }
            if (n1 == n2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.hasCycle2(node1);
        System.out.println("end");
    }
}
