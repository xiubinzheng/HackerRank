package com.codility;

import java.util.Arrays;

/**
 * @author Anatoly Chernysh
 */
public class MaxProductOfThree {

    public static void main(String[] args) {
        int A[] = new int[6];
        A[0] = -3;
        A[1] = 1;
        A[2] = 2;
        A[3] = -2;
        A[4] = 5;
        A[5] = 6;
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);

        boolean isZeroPresent = false;

        int sum1 = 1, j = 0;
        for (int i = 1;i <= A.length;i++) {
            if (A[A.length - i] != 0) {
                sum1 *= A[A.length - i];
                j++;
                if (j == 3) {
                    break;
                }
            }
            else {
                isZeroPresent = true;
            }
        }
        if (j != 3) {
            if (isZeroPresent) {
                sum1 = 0;
            }
            else {
                sum1 = Integer.MIN_VALUE;
            }
        }

        int sum2 = Integer.MIN_VALUE;
        if (A[0] < 0 && A[1] < 0) {
            sum2 = A[0] * A[1];

            j = 0;
            for (int i = 1;i <= A.length;i++) {
                if (A[A.length - i] != 0) {
                    sum2 *= A[A.length - i];
                    j = 1;
                    break;
                }
                else {
                    isZeroPresent = true;
                }
            }
            if (j != 1) {
                if (isZeroPresent) {
                    sum2 = 0;
                }
                else {
                    sum2 = Integer.MIN_VALUE;
                }
            }
        }

        return sum1 > sum2 ? (sum1 < 0 & isZeroPresent ? 0 : sum1) : (sum2 < 0 & isZeroPresent ? 0 : sum2);
    }
}
