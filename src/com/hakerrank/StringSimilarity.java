package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class StringSimilarity {

    static long stringSimilarity(String str) {
        int res = str.length();

        for (int i = 1;i < str.length();i++) {
            String subStr = str.substring(i);
            for (int j = 0; j <  subStr.length();j++) {
                if (subStr.charAt(j) == str.charAt(j)) {
                    res++;
                }
                else {
                    break;
                }
            }
        }

        return res;
    }

    static long stringSimilarityEx(String str) {
        int res = str.length();

        char []strChars = str.toCharArray();

        for (int i = 1;i < strChars.length;i++) {
            for (int j = 0; j <  strChars.length - i;j++) {
                if (strChars[i + j] == strChars[j]) {
                    res++;
                }
                else {
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;

        int amountOfTestCases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < amountOfTestCases; i++) {
            String str = in.nextLine();
            res = stringSimilarityEx(str);
            System.out.println(res);
        }
    }


}
