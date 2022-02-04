package com.cier.solution.list;

import com.cier.solution.common.ListNode;

/**
 * [1290] 二进制链表转整数
 *
 * @author liuenci
 */
public class GetDecimalValue {

    public int getDecimalValue(ListNode head) {
        return getInteger(getString(head));
    }

    private String getString(ListNode head) {
        StringBuilder str = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            str.append(cur.val);
            cur = cur.next;
        }
        return str.toString();
    }

    public int getInteger(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        int p = 0;
        int res = 0;
        int binaryInt = Integer.parseInt(str);
        while (binaryInt != 0) {
            int d = binaryInt % 10;
            res = res + d * (int) Math.pow(2, p);
            p++;
            binaryInt = binaryInt / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(0);
        root.next = node1;
        ListNode node2 = new ListNode(0);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        GetDecimalValue g = new GetDecimalValue();
        System.out.println(g.getDecimalValue(root));
    }
}
