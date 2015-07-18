package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class GameOfThronesI {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();

        int alphabet[] = new int[27];
        for (int i = 0;i < inputString.length();i++) {
            alphabet[inputString.charAt(i) - 'a']++;
        }

        int amountOddGroupOfCharacters = 0;
        for (int i = 0;i < alphabet.length;i++) {
            if (alphabet[i] != 0) {
                if (alphabet[i] % 2 == 1) {
                    amountOddGroupOfCharacters++;
                }
            }
        }

        System.out.println(amountOddGroupOfCharacters > 1 ? "NO" : "YES");

        myScan.close();
    }

}
