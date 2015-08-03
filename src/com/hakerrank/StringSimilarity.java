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

    // http://codeforces.com/blog/entry/3107
    static long z(String str) {
        int n = str.length();
        int []z = new int[n];
        char []s = str.toCharArray();

        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && s[R-L] == s[R]) R++;
                z[i] = R-L; R--;
            } else {
                int k = i-L;
                if (z[k] < R-i+1) z[i] = z[k];
                else {
                    L = i;
                    while (R < n && s[R-L] == s[R]) R++;
                    z[i] = R-L; R--;
                }
            }
        }

        long res = 0;
        for (int i = 1; i < n; i++) {
            res += z[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;

        int amountOfTestCases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < amountOfTestCases; i++) {
            String str = in.nextLine();
            //res = stringSimilarityEx(str);
            res = z(str) + str.length();
            System.out.println(res);
        }
    }


}
