package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class SansaAndXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int amountOfTestCases = in.nextInt();

        for (int i = 0;i < amountOfTestCases;i++) {

            int[] arr = new int[in.nextInt()];
            for(int j = 0;j < arr.length;j++){
                arr[j] = in.nextInt();
            }
            System.out.println(calculateXOR(arr));
        }
    }

    public static int calculateXOR(int []arr) {
        if (arr.length % 2 == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0;i < arr.length;i++) {
            if ((i + 1) % 2 == 1) {
                result ^= arr[i];
            }
        }

        return result;
    }
}
