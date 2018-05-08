package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        /*
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        */

        /*
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        */

        /*
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        */

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);

        ListNode node = mergeTwoLists(l1, l2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * Ugly, but works.
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current = null, mergedList = null;

        if (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                current = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                current = new ListNode(l1.val);
                l1 = l1.next;
            }
        }
        else if (l1 == null && l2 != null) {
            current = new ListNode(l2.val);
            l2 = l2.next;
        }
        else if (l2 == null && l1 != null) {
            current = new ListNode(l1.val);
            l1 = l1.next;
        }
        else {
            return null;
        }
        mergedList = current;

        while (true) {

            if (l1 == null && l2 == null) {
                break;
            }

            if (l2 == null && l1 != null) {
                current.next = l1;
                l1 = l1.next;
            }
            else if (l1 == null && l2 != null) {
                current.next = l2;
                l2 = l2.next;
            }
            else {
                if (l1.val >= l2.val) {
                    current.next = l2;
                    l2 = l2.next;
                }
                else {
                    current.next = l1;
                    l1 = l1.next;
                }
            }

            current = current.next;
        }

        return mergedList;
    }

}
