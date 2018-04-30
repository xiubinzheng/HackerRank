package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class StrStr {

    public static void main(String[] args) {
        //String haystack = "hello", needle = "ll";
        //String haystack = "aaaaa", needle = "bba";
        //String haystack = "mississippi", needle = "issip";
        //System.out.println(strStr(haystack, needle));
        //System.out.println(strStr("mississippi", "issip"));
        //System.out.println(strStr("mississippi", "issi"));
        //System.out.println(strStr("mississippi", "pi"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int index = -1;
        for (int i = 0, j = 0;i < haystack.length();i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            else {
                if (j >= needle.length()) {
                    return i - needle.length() + 1;
                }
                if (j > 0) {
                    i = i - j;
                }
                j = 0;
            }
            if (j >= needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return index;
    }
}
