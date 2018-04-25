package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anatoly Chernysh
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        //String s = "egg", t = "add";
        //String s = "paper", t = "title";
        String s = "foo", t = "bar";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String str1, String str2) {
        Map<Character, Integer> mapStr1 = new HashMap<Character, Integer>();
        Map<Character, Integer> mapStr2 = new HashMap<Character, Integer>();

        for (int i = 0;i < str1.length();i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            int valueCh1 = -1;
            if (mapStr1.containsKey(ch1)) {
                valueCh1 = mapStr1.get(ch1);
            }
            else {
                mapStr1.put(ch1, i);
            }

            int valueCh2 = -1;
            if (mapStr2.containsKey(ch2)) {
                valueCh2 = mapStr2.get(ch2);
            }
            else {
                mapStr2.put(ch2, i);
            }

            if (valueCh1 != valueCh2) {
                return false;
            }

        }

        return true;
    }
}
