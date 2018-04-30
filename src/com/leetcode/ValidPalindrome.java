package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        /*
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome(".."));
        System.out.println(isPalindrome("0P"));
        */
        System.out.println(isPalindrome("aa"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder clearedStr = new StringBuilder();
        for (int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                clearedStr.append(ch);
            }
        }
        s = clearedStr.toString().toLowerCase();
        if (s.isEmpty()) {
            return true;
        }

        for (int i = 0, j = s.length() - 1;i != j && i < s.length() - 1 && j >= 0;i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

}
