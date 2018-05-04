package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        //String []strs = {"dog","racecar","car"};
        //System.out.println(longestCommonPrefix(strs));

        String []strs = {};
        System.out.println(longestCommonPrefix(strs));

        /*
        String []strs = {"flower",
                "flow",
                "flight"
        };
        System.out.println(longestCommonPrefix(strs));
        */
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder prefix = new StringBuilder();
        int prefixIndex = 0;

        for (;;) {
            boolean matchPrefix = true;
            for (int i = 0; i < strs.length; i++) {
                if (prefixIndex > strs[i].length() - 1) {
                    matchPrefix = false;
                    break;
                }
                if (strs[i].charAt(prefixIndex) != strs[0].charAt(prefixIndex)) {
                    matchPrefix = false;
                    break;
                }
            }
            if (!matchPrefix) {
                return prefix.toString();
            }
            prefix.append(strs[0].charAt(prefixIndex));
            prefixIndex++;

        }
    }
}