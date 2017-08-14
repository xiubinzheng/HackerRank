package com.codility;

/**
 * @author Anatoly Chernysh
 *
 * https://codility.com/programmers/task/number_solitaire/
 */
public class NumberSolitaire {

    public static void main(String[] args) {
        /*
        int []A = new int[6];
        A[0] = 1;
        A[1] = -2;
        A[2] = 0;
        A[3] = 9;
        A[4] = -1;
        A[5] = -2;
        // 8
        */

        /*
        int []A = new int[2];
        A[0] = 1;
        A[1] = -2;
        // -1
        */

        int []A = new int[3];
        A[0] = -4;
        A[1] = -10;
        A[2] = -7;
        // -11
        System.out.println(numberSolitaire(A));
    }

    public static int numberSolitaire(int []A) {
        int[] dynamicA = new int[A.length];
        dynamicA[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            int max = dynamicA[i - 1] + A[i];
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    max = Math.max(dynamicA[i - j] + A[i], max);
                }
            }
            dynamicA[i] = max;
        }
        return dynamicA[A.length - 1];
    }
}
