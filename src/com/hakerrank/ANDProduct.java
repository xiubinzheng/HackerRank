package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class ANDProduct {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int amountTestCases = Integer.parseInt(in.nextLine());

        for (int i = 0;i < amountTestCases;i++) {
            String []values = in.nextLine().split(" ");
            System.out.println(bitwiseAND(Long.valueOf(values[0]), Long.valueOf(values[1])));
        }
    }

    public static long bitwiseAND(long l, long j) {
        long result = l;

        for (long i = l;i <= j;i++) {
            result &= i;
        }

        return result;
    }
}
