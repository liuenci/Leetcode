package com.cier.solution.list;

import com.cier.solution.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * [剑指Offer 06] 从尾到头打印链表
 *
 * @author liuenci
 */
public class ReversePrint {


    public int[] reversePrint(ListNode head) {
        List<Integer> sortList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            sortList.add(cur.val);
            cur = cur.next;
        }
        int[] res = new int[sortList.size()];
        for (int i = sortList.size() - 1; i >= 0; i--) {
            res[sortList.size() - i - 1] = sortList.get(i);
        }
        return res;
    }
}
