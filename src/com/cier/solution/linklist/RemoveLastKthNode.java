package com.cier.solution.linklist;

import com.cier.solution.common.DoubleNode;
import com.cier.solution.common.Node;

public class RemoveLastKthNode {

    // 在单链表中删除倒数第K个节点
    public Node removeLastKthNode1(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node curNode = head;
        while (curNode != null) {
            lastKth--;
            curNode = curNode.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            curNode = head;
            while (++lastKth != 0) {
                curNode = curNode.next;
            }
            curNode.next = curNode.next.next;
        }
        return head;
    }
    // 在双链表中删除倒数第K个节点
    public DoubleNode removeLastKthNode2(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1){
            return head;
        }
        DoubleNode curNode = head;
        while (curNode != null){
            lastKth--;
            curNode = curNode.next;
        }
        if (lastKth == 0){
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0){
            curNode = head;
            while (++lastKth != 0){
                curNode = curNode.next;
            }
            curNode.next = curNode.next.next;
            if (curNode.next != null){
                curNode.next.last = curNode;
            }
        }
        return head;
    }
}
