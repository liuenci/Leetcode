package com.cier.solution.list;

import com.cier.solution.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * [剑指 Offer 027] 回文链表
 * @author liuenci
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }

        int left = 0;
        int right = res.size() - 1;
        while (left <= right) {
            if (!res.get(left).equals(res.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
