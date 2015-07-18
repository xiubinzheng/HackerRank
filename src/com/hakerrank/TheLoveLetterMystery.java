package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class TheLoveLetterMystery {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountOfTestCases = Integer.valueOf(in.nextLine());
        for(int i = 0;i < amountOfTestCases;i++){
            System.out.println(makePalindrome(in.nextLine()));
        }
    }

    public static int makePalindrome(String word) {
        int amountOfChanges = 0;

        for (int i = 0;i < word.length() / 2;i++) {
            char fromStart = word.charAt(i);
            char fromEnd = word.charAt(word.length() - 1 - i);

            if (fromEnd != fromStart) {
                amountOfChanges += Math.abs(fromEnd - fromStart);
            }
        }

        return amountOfChanges;
    }

}
