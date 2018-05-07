package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        /*
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node = removeNthFromEnd(node, 2);
        */

        /*
        ListNode node = new ListNode(1);
        node = removeNthFromEnd(node, 1);
        */

        /*
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node = removeNthFromEnd(node, 2);
        */

        /*
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node = removeNthFromEnd(node, 2);
        */

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node = removeNthFromEnd(node, 2);


        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1;i <= n + 1;i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

}
