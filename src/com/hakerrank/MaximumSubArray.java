package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class MaximumSubArray {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int amountTestCases = Integer.parseInt(in.nextLine());

        for (int i = 0;i < amountTestCases;i++) {
            int arraySize = Integer.parseInt(in.nextLine());
            int []array = new int[arraySize];

            String []stringArray = in.nextLine().split(" ");
            for (int j = 0;j < stringArray.length;j++) {
                array[j] = Integer.valueOf(stringArray[j]);
            }
            System.out.println(maxContiguousSubArray(array) + " " + maxNonContiguousSubArray(array));
        }
    }

    public static long maxContiguousSubArray(int []array) {
        long maxSoFar = Integer.MIN_VALUE, maxEndingHere = maxSoFar;

        for (int i = 0;i < array.length;i++) {
            maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }

    public static long maxNonContiguousSubArray(int []array) {
        long maxSoFarForPositive = 0;
        long maxSoFarForNegative = Long.MIN_VALUE;

        boolean isPositiveExists = false;

        for (int i = 0;i < array.length;i++) {
            if (array[i] >= 0 ) {
                maxSoFarForPositive += array[i];
                isPositiveExists = true;
            }
            else {
                maxSoFarForNegative = Math.max(maxSoFarForNegative, array[i]);
            }
        }

        if (isPositiveExists) {
            return maxSoFarForPositive;
        }

        return maxSoFarForNegative;
    }
}
