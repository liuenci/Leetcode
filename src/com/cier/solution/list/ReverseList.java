package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [剑指 Offer 24] 反转链表
 * @author liuenci
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 假设其他的节点都已经反转好了
        ListNode temp = reverseList(head.next);
        // 这里不能用 temp.next = head
        head.next.next = head;
        // 最后将头结点的下一个节点置为 null 即可
        head.next = null;
        return temp;
    }

}
