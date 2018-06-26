package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        for (int i = 0;i < matrix.length;i++) {
            for (int j = i;j < matrix[0].length;j++) {
                if (i == j) {
                    continue;
                }
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0;i < matrix.length;i++) {
            reverse(matrix[i]);
        }
    }

    private static void reverse(int []row) {
        int start = 0, end = row.length - 1;
        while (start <= end) {
            int tmp = row[start];
            row[start] = row[end];
            row[end] = tmp;
            start++;
            end--;
        }
    }

    private static void print(int [][]matrix) {
        for (int []row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

        public static void main(String[] args) {
        int [][]matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

            /*
        int [][]matrix = {
                {5, 1, 9, 11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}};
                */

        rotate(matrix);
        print(matrix);
    }
}
