package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class DiagonalDifference {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0;i < n;i++){
            for (int j = 0;j < n;j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(sumDiagonalDifference(arr));
    }

    public static int sumDiagonalDifference(int [][]matrix) {
        int sum1 = 0, sum2 = 0;

        for (int i = 0;i < matrix.length;i++) {
            sum1 += matrix[i][i];
            sum2 += matrix[i][matrix.length - i - 1];
        }

        return Math.abs(sum1 - sum2);
    }
}
