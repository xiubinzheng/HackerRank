package com.leetcode;

import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reorderList(node);


        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /*
    public static void reorderList(ListNode head) {
        ListNode current = head;
        List<ListNode> indexedNodes = new ArrayList<ListNode>();
        while (current != null) {
            indexedNodes.add(current);
            current = current.next;
        }

        if (indexedNodes.size() > 1) {
            current = head;
            for (int i = 0; i < indexedNodes.size() / 2; i++) {
                ListNode currentFromBegin = current.next;
                ListNode currentFromEnd = indexedNodes.get(indexedNodes.size() - 1 - i);
                if (currentFromBegin.val == currentFromEnd.val) {
                    break;
                }
                ListNode currentEnd = indexedNodes.get(indexedNodes.size() - 2 - i);
                currentEnd.next = null;

                current.next = currentFromEnd;
                current.next.next = currentFromBegin;
                current = currentFromBegin;
            }
        }
    }
    */

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // find mid
        ListNode fastCurrent = head, current = head, prev = null;
        while (fastCurrent != null) {
            prev = current;
            current = current.next;
            fastCurrent = fastCurrent.next;
            if (fastCurrent != null) {
                fastCurrent = fastCurrent.next;
            }
        }
        if (prev != null) {
            prev.next = null;
        }

        // reverse list after mid
        ListNode tail = new ListNode(current.val);
        while (current.next != null) {
            ListNode tmp = tail;
            tail = new ListNode(current.next.val);
            tail.next = tmp;
            current = current.next;
        }

        // join 2 list
        ListNode p1 = head, p2 = tail;
        while (p1 != null && p2 != null) {
            ListNode tmp1 = p1.next;
            p1.next = p2;
            ListNode tmp2 = p2.next;
            p2.next = tmp1;
            p1 = tmp1;
            p2 = tmp2;
        }
    }

}
