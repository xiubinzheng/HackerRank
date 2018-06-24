package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        /*
        int [][]matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
                */

        /*
        int [][]matrix = {
                {0,1,2,5},
                {3,4,5,2},
                {1,3,1,0}};
                */

        /*
        int [][]matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
                */

        int [][]matrix = {{1}};
        setZeroes(matrix);
        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0;j < matrix[0].length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int zeroRow = -1, zeroColumn = -1;
        boolean zeroFlag = false;

        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0;j < matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    if (!zeroFlag) {
                        zeroFlag = true;
                        zeroRow = i;
                        zeroColumn = j;
                    }
                    else if (i != zeroRow && zeroColumn != j) {
                        matrix[zeroRow][j] = 0;
                        matrix[i][zeroColumn] = 0;
                    }
                }
            }
        }
        if (!zeroFlag) {
            return;
        }

        for (int j = 0;j < matrix[0].length;j++) {
            if (j != zeroColumn && matrix[zeroRow][j] == 0) {
                for (int i = 0;i < matrix.length;i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0;i < matrix.length;i++) {
            if (matrix[i][zeroColumn] == 0) {
                for (int j = 0;j < matrix[0].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0;i < matrix.length;i++) {
            matrix[i][zeroColumn] = 0;
        }
        for (int j = 0;j < matrix[0].length;j++) {
            matrix[zeroRow][j] = 0;
        }
    }

}
