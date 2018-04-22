package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anatoly Chernysh
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("aacc", "ccaa"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charactersUsage = new HashMap<>();
        for (int i = 0;i < s.length();i++) {
            if (charactersUsage.containsKey(s.charAt(i))) {
                charactersUsage.put(s.charAt(i), charactersUsage.get(s.charAt(i)) + 1);
            }
            else {
                charactersUsage.put(s.charAt(i), 1);
            }
        }

        for (int i = 0;i < t.length();i++) {
            if (charactersUsage.containsKey(t.charAt(i))) {
                charactersUsage.put(t.charAt(i), charactersUsage.get(t.charAt(i)) - 1);
            }
        }

        for (Map.Entry<Character, Integer> value : charactersUsage.entrySet()) {
            if (value.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
