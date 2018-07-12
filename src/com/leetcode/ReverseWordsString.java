package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ReverseWordsString {

    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();

        String items[] = s.split("\\s+");
        for (int i = items.length - 1 ;i >= 0;i--) {
            sb.append(items[i].trim()).append(' ');
        }
        return sb.toString().trim();
    }

}
