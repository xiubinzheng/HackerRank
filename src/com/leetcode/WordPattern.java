package com.leetcode;

import java.util.HashMap;

/**
 * @author Anatoly Chernysh
 */
public class WordPattern {

    public static void main(String[] args) {
        //String pattern = "abba";
        //String str = "dog cat cat dog";
        //String str = "dog cat cat fish";


        String pattern = "aaa";
        String str = "aa aa aa aa";


        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {
        final HashMap<String, Character> wordToPattern = new HashMap<String, Character>();
        final String []words = str.split(" ");
        int patternIndex = 0;
        if (words.length != pattern.length()) {
            return false;
        }

        for (String word : words) {
            if (!wordToPattern.containsKey(word)) {
                if (wordToPattern.containsValue(pattern.charAt(patternIndex))) {
                    return false;
                }
                wordToPattern.put(word, pattern.charAt(patternIndex++));
            }
            else {
                if (wordToPattern.get(word) != pattern.charAt(patternIndex++)) {
                    return false;
                }
            }
        }

        return true;
    }
}
