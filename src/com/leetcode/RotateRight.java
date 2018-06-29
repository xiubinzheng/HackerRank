package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RotateRight {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode result = rotateRight(node, 2);

        /*

        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        ListNode result = rotateRight(node, 4);
        */

        /*
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        ListNode result = rotateRight(node, 1);
        */

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = head, slow = head;
        int i = 1;
        while (fast.next != null) {
            i++;
            fast = fast.next;
        }

        for (int j = (i - k % i);j > 1;j--) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
