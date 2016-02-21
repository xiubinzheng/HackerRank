package com.codility;

/**
 * @author Anatoly Chernysh
 */
public class MaxProfit {

    public static void main(String[] args) {
        int []A = new int[6];
        A[0] = 23171;
        A[1] = 21011;
        A[2] = 21123;
        A[3] = 21366;
        A[4] = 21013;
        A[5] = 21367;

        /*
        int []A = new int[6];
        A[0] = 6;
        A[1] = 7;
        A[2] = 10;
        A[3] = 3;
        A[4] = 8;
        A[5] = 1;
        */

        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int minPrice = A[0];
        int maxSoFar = 0;
        int currentMax = 0;

        for (int i = 1;i < A.length;i++) {
            currentMax =  Math.max(0, A[i] - minPrice);
            maxSoFar = Math.max(maxSoFar, currentMax);
            minPrice = Math.min(minPrice, A[i]);
        }

        return maxSoFar;
    }
}
