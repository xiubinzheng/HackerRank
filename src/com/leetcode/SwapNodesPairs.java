package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class SwapNodesPairs {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        //node.next.next.next.next.next.next.next = new ListNode(8);
        node = swapPairs(node);


        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = swap(head), current = newHead;
        current = current.next;
        head = head.next;
        while (head != null) {
            current.next = swap(head);
            current = current.next.next;
            head = head.next;
        }
        return newHead;
    }

    public static ListNode swap(ListNode item) {
        ListNode newHead = item.next;
        if (item.next == null) {
            return item;
        }
        ListNode tmp = item.next.next;
        newHead.next = item;
        newHead.next.next = tmp;
        return newHead;
    }

}
