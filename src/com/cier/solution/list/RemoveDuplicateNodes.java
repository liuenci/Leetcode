package com.cier.solution.list;

import com.cier.solution.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * [面试题 02.01] 移除重复节点
 * @author liuenci
 */
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (set.contains(cur.val)) {
                cur = cur.next;
                prev.next = cur;
            } else {
                set.add(cur.val);
                cur = cur.next;
                prev = prev.next;
            }
        }
        return head;
    }
}
