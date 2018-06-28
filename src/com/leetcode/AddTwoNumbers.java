package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode sum = head;

        int carry = 0;

        while (true) {
            if (l2 == null && l1 == null) {
                break;
            }

            int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            if (val >= 10) {
                carry = 1;
                String tmp = String.valueOf(val);
                val = tmp.charAt(tmp.length() - 1) - 48;
            }
            else {
                carry = 0;
            }
            sum.next = new ListNode(val);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            sum = sum.next;
        }
        if (carry != 0) {
            sum.next = new ListNode(1);
        }

        return head.next;
    }
}
