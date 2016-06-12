package com.hakerrank;

/**
 * @author Anatoly Chernysh
 */
public class KnuthMorrisPratt {

    public static void main(String[] args) {
        System.out.println(kmp("bla-bla test bla", "aabbaaa"));
    }

    public int[] preKMP(String pattern) {
        int []next = new int[pattern.length()];

        for (int i = 0;i < pattern.length() - 1;i++) {
            for (int j = 0;j < pattern.length() - 1;j++) {
            }
        }

        return next;
    }

    public static int kmp(String text, String pattern) {
        int[] next = prekmp(pattern);
        int i=0, j=0;
        while (i<text.length()) {
            while (j>=0 && text.charAt(i)!=pattern.charAt(j))
                j = next[j];
            i++; j++;
            if (j==pattern.length()) return i-pattern.length();
        }
        return -1;
    }

    public static int[] prekmp(String pattern) {
        int[] next = new int[pattern.length()];
        int i=0, j=-1;
        next[0]=-1;
        while (i<pattern.length()-1) {
            while (j>=0 && pattern.charAt(i)!=pattern.charAt(j)) {
                j = next[j];
            }
            i++;
            j++;
            next[i] = j;
        }
        return next;
    }

}
