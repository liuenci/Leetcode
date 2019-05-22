package com.cier.solution.linklist;

import com.cier.solution.common.ListNode;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    /**
     * Runtime: 2 ms, faster than 94.85% of Java online submissions for Add Two Numbers.
     * Memory Usage: 43.5 MB, less than 87.44% of Java online submissions for Add Two Numbers.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        // one 用来判断是否应该进位
        boolean one = false;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (one) {
                val += 1;
            }
            // 判断是否进位
            if (val >= 10) {
                val -= 10;
                one = true;
            }else {
                one = false;
            }
            if (head == null) {
                head = tail = new ListNode(val);
            }else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }
        if (one) {
            tail.next = new ListNode(1);
        }
        return head;
    }

    /**
     * Runtime: 2 ms, faster than 94.96% of Java online submissions for Add Two Numbers.
     * Memory Usage: 44.1 MB, less than 86.22% of Java online submissions for Add Two Numbers.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else {

            if (l1.val + l2.val < 10) {
                l3 = new ListNode(l1.val + l2.val);
                l3.next = addTwoNumbers2(l1.next, l2.next);
            }else {
                l3 = new ListNode(l1.val + l2.val - 10);
                l3.next = addTwoNumbers2(l1.next, addTwoNumbers2(l2.next, new ListNode(1)));
            }
        }
        return l3;
    }

    /**
     * Runtime: 14 ms, faster than 52.43% of Java online submissions for Add Two Numbers.
     * Memory Usage: 37.6 MB, less than 99.88% of Java online submissions for Add Two Numbers.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        String numStr1 = String.valueOf(l1.val);
        String numStr2 = String.valueOf(l2.val);

        while (l1.next != null) {
            numStr1 += String.valueOf(l1.next.val);
            l1 = l1.next;

        }

        while (l2.next != null) {
            numStr2 += String.valueOf(l2.next.val);
            l2 = l2.next;
        }

        BigInteger num1 = new BigInteger(new StringBuffer(numStr1).reverse().toString());
        BigInteger num2 = new BigInteger(new StringBuffer(numStr2).reverse().toString());

        BigInteger sum = num1.add(num2);

        String sumStr = new StringBuffer(String.valueOf(sum)).reverse().toString();

        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i = 0; i < sumStr.length(); i++) {
            head.next = new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(i))));
            head = head.next;
        }
        return dummy.next;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            result.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = l1.val + l2.val + carry >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        while (l1 != null) {
            result.next = new ListNode((l1.val + carry) % 10);
            carry = l1.val + carry >= 10 ? 1 : 0;
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            result.next = new ListNode((l2.val + carry) % 10);
            carry = l2.val + carry >= 10 ? 1 : 0;
            result = result.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(8);
        node4.next = node5;
        node5.next = node6;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers(node1, node4);
        System.out.println();
    }
}
