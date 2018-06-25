package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class FindDifference {

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }

    public static char findTheDifference(String s, String t) {
        int alphabet[] = new int [26];

        for (int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            alphabet[(int)(ch - 'a')]++;
        }

        for (int i = 0;i < t.length();i++) {
            char ch = t.charAt(i);
            alphabet[(int)(ch - 'a')]--;
        }

        for (int i = 0;i < alphabet.length;i++) {
            if (alphabet[i] != 0) {
                return (char)(i + 'a');
            }
        }

        return ' ';
    }
}