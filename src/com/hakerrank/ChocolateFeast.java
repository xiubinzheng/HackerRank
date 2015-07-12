package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }

    private static int Solve(int sumInPocket, int chocolatePrice, int amountOfWrappers) {
        int amountOfChocolates = sumInPocket / chocolatePrice;

        if (amountOfChocolates >= amountOfWrappers) {
            int tempAmountOfChocolates = amountOfChocolates;

            while (true) {
                int extraAmountOfChocolates = tempAmountOfChocolates / amountOfWrappers;
                if (extraAmountOfChocolates == 0) {
                    break;
                }

                int wrappers = amountOfChocolates % amountOfWrappers;
                tempAmountOfChocolates = extraAmountOfChocolates + wrappers;

                amountOfChocolates += extraAmountOfChocolates;
            }
        }

        return amountOfChocolates;
    }
}
