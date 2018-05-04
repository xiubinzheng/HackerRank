package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        //System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("a"));
    }

    public static int lengthOfLastWord(String s) {
        int index = 0;
        if (s.isEmpty()) {
            return index;
        }

        s = s.trim();
        for (int i = s.length() - 1;i >= 0;i--) {
            if (s.charAt(i) == ' ') {
                return s.length() - 1 - i;

            }
        }

        return s.length();
    }

}
