package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class InsertionSortList {

    public static void main(String[] args) {
        /*
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        */

        /*
        ListNode node = new ListNode(-1);
        node.next = new ListNode(5);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(0);
        */

        /*
        ListNode node = new ListNode(-1);
        node.next = new ListNode(-2);
        */

        /*
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        */

        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(-3);


        ListNode sorted = insertionSortList(node);
        while (sorted != null) {
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
    }


    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head.next, sortedHead = new ListNode(head.val);

        while (current != null) {
            ListNode currentSorted = sortedHead;
            if (current.val < currentSorted.val) {
                sortedHead = new ListNode(current.val);
                sortedHead.next = currentSorted;
            }
            else {
                ListNode prev = null;
                boolean hasAdded = false;
                while (currentSorted != null) {
                    if (currentSorted.val >= current.val && prev != null) {
                        ListNode tmp = currentSorted;
                        prev.next = new ListNode(current.val);
                        prev.next.next = tmp;
                        hasAdded = true;
                        break;
                    }
                    prev = currentSorted;
                    currentSorted = currentSorted.next;
                }
                if (!hasAdded) {
                    prev.next = new ListNode(current.val);
                }
            }

            current = current.next;
        }

        return sortedHead;
    }
}
