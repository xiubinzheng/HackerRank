package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class IntersectionNode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(11);
        l1.next = new ListNode(12);
        l1.next.next = new ListNode(13);
        l1.next.next.next = new ListNode(14);
        l1.next.next.next.next = new ListNode(15);

        ListNode l2 = new ListNode(12);
        l2.next = new ListNode(22);
        l2.next.next = new ListNode(23);
        l2.next.next.next = l1.next.next;

        ListNode node = getIntersectionNode(l1, l2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            if (node1 != null) {
                node1 = node1.next;
            }
            else {
                node1 = headB;
            }

            if (node2 != null) {
                node2 = node2.next;
            }
            else {
                node2 = headA;
            }
        }

        return node1;
    }
}
