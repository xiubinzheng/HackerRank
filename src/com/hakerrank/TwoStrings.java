package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class TwoStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountOfTestCases = Integer.valueOf(in.nextLine());

        for(int j = 0;j < amountOfTestCases;j++) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();

            int []alphabet = new int[27];

            for (int i = 0;i < str1.length();i++) {
                int charInx = str1.charAt(i) - 'a';
                if (alphabet[charInx] == 0) {
                    alphabet[charInx]++;
                }
            }

            boolean isSubString = false;
            for (int i = 0;i < str2.length();i++) {
                int charInx = str2.charAt(i) - 'a';
                if (alphabet[charInx] == 1) {
                    isSubString = true;
                    break;
                }
            }

            System.out.println(isSubString ? "YES" : "NO");
        }
    }
}
