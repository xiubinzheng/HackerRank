package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class SherlockAndSquares {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountOfTestCases = in.nextInt();

        for(int i = 0;i < amountOfTestCases;i++){
            int min = in.nextInt();
            int max = in.nextInt();

            int amountOfSquares = 0;
            for (int j = 1;;j++) {
                int jj = j * j;
                if (jj >= min && jj <= max) {
                    amountOfSquares++;
                }
                else if (jj > max) {
                    break;
                }
            }

            System.out.println(amountOfSquares);
        }

    }
}
