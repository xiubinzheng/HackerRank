package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class UtopianTree {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int amountTestCases = Integer.parseInt(in.nextLine());

        for (int i = 0;i < amountTestCases;i++) {
            Integer N = in.nextInt();
            System.out.println(calculateHeightUtopianTree(N));
        }
    }

    public static long calculateHeightUtopianTree(int amountOfGrowthCycles) {
        long startHeight = 1;

        if (amountOfGrowthCycles == 0) {
            return startHeight;
        }

        if (amountOfGrowthCycles == 1) {
            return startHeight * 2;
        }

        for (int i = 1;i <= amountOfGrowthCycles;i++) {
            if (i % 2 != 0) {
                startHeight *= 2;
            }
            else {
                startHeight += 1;
            }
        }

        return startHeight;
    }

}
