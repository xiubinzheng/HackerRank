package com.hakerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class TwoArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountOfTestCases = in.nextInt();

        for (int i = 0;i < amountOfTestCases;i++) {
            int amountOfElements = in.nextInt();
            int K = in.nextInt();

            Integer []arrA = new Integer[amountOfElements];
            for(int j = 0;j < arrA.length;j++) {
                arrA[j] = in.nextInt();
            }

            Integer []arrB = new Integer[amountOfElements];
            for(int j = 0;j < arrB.length;j++) {
                arrB[j] = in.nextInt();
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB, Collections.reverseOrder());

            boolean result = true;
            for (int j = 0;j < arrA.length;j++) {
                if (arrA[j] + arrB[j] < K) {
                    result = false;
                    break;
                }
            }
            System.out.println(result ? "YES" : "NO");
        }
    }
}
