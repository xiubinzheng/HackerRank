package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anatoly Chernysh
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode('m');
        head.next = new ListNode('a');
        head.next.next = new ListNode('d');
        head.next.next.next = new ListNode('a');
        head.next.next.next.next = new ListNode('m');
        System.out.println(isPalindrome(head));

        //System.out.println(isPalindrome(null));

        /*
        ListNode head = new ListNode('0');
        head.next = new ListNode('0');
        System.out.println(isPalindrome(head));
        */

        /*
        ListNode head = new ListNode('1');
        head.next = new ListNode('0');
        head.next.next = new ListNode('0');
        System.out.println(isPalindrome(head));
        */
    }

    public static boolean isPalindrome(ListNode head) {
        StringBuilder result = new StringBuilder();
        while (head != null) {
            result.append((char)head.val);
            head = head.next;
        }

        for (int i = 0, j = result.length() - 1;i < result.length() / 2;i++, j--) {
            if (result.charAt(i) != result.charAt(j)) {
                return false;
            }
        }

        return true;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}