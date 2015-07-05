package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class MakeItAnagram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(makeItAnagram(in.nextLine(), in.nextLine()));
    }

    public static int makeItAnagram(String str1, String str2) {
        StringBuffer sb1 = new StringBuffer(str1);
        StringBuffer sb2 = new StringBuffer(str2);

        for (int i = 0;i < str1.length();i++) {
            char ch = str1.charAt(i);
            int inx1 = sb1.indexOf(String.valueOf(ch));
            int inx2 = sb2.indexOf(String.valueOf(ch));

            if (inx1 != -1 && inx2 != -1) {
                sb1 = sb1.deleteCharAt(inx1);
                sb2 = sb2.deleteCharAt(inx2);
            }
        }

        return sb1.length() + sb2.length();
    }
}
