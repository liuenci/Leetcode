package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [面试题 02.02] 返回倒数第 k 个节点
 * @author liuenci
 */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        int index = getLength(head) - k;
        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }
}
