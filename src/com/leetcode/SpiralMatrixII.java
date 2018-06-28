package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int [][]matrix = new int[n][n];
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;

        int count = 1;

        while (r1 <= r2 && c1 <= c2) {

            // top
            for (int j = c1;j <= c2;j++) {
                matrix[r1][j] = count++;
            }
            r1++;

            // right
            for (int i = r1;i <= r2;i++) {
                matrix[i][c2] = count++;
            }
            c2--;

            if (r1 <= r2 && c1 <= c2) {
                // bottom
                for (int j = c2; j >= c1; j--) {
                    matrix[r2][j] = count++;
                }
                r2--;

                // left
                for (int i = r2; i >= r1; i--) {
                    matrix[i][c1] = count++;
                }
                c1++;
            }
        }

        return matrix;
    }
}
