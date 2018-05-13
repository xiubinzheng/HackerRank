package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class DeleteNodeLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        deleteNode(node.next.next);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
