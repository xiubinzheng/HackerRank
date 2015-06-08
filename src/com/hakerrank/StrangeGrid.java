package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class StrangeGrid {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        String []values = in.nextLine().split(" ");
        System.out.println(calculateStrangeGridNumber(Long.valueOf(values[0]), Long.valueOf(values[1])));
    }

    public static long calculateStrangeGridNumber(long r, long c) {
        int number = 0;

        if (r == 1 && c == 1) {
            return number;
        }

        if (r == 1) {
            return (c - 1) * 2;
        }

        if (r == 2) {
            return (c - 1) * 2 + 1;
        }

        long groupNumber = (r + 1) / 2;

        long oddResult = (groupNumber - 1) * 10 + (c - 1) * 2;
        if (r % 2 != 0) {
            return oddResult;
        }
        else {
            return oddResult + 1;
        }
    }
}
