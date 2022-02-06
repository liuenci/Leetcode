package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [面试题 02.03] 删除中间节点
 * @author liuenci
 */
public class DeleteNode2 {

    /**
     * 本题的难度在于，传进来的根本不是链表的头结点 WC
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
