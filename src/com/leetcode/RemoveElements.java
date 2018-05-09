package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RemoveElements {

    public static void main(String[] args) {
        /*
        ListNode l1 = new ListNode(11);
        l1.next = new ListNode(12);
        l1.next.next = new ListNode(13);
        l1.next.next.next = new ListNode(14);
        l1.next.next.next.next = new ListNode(15);
        */

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);

        ListNode node = removeElements(l1, 1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode current = head;

        if (current == null) {
            return null;
        }
        else if (current.val == val) {
            head = head.next;
            while (head != null) {
                if (head.val == val) {
                    head = head.next;
                }
                else {
                    break;
                }
            }
            current = head;
        }

        while (current != null) {
            if (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }

        return head;
    }

}
