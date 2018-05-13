package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        node = reverseList(node);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tail = new ListNode(head.val);

        while (head.next != null) {
            ListNode tmp = tail;
            tail = new ListNode(head.next.val);
            tail.next = tmp;
            head = head.next;
        }

        return tail;
    }
}
