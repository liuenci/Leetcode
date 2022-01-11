package com.cier.solution.list;

import com.cier.solution.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * [141] 环形链表
 * @author liuenci
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode prev = head;
        while (prev != null) {
            if (set.contains(prev)){
                return true;
            } else {
                set.add(prev);
            }
            prev = prev.next;
        }
        return false;
    }
}
