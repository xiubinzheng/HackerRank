package com.leetcode;

import java.util.Arrays;

/**
 * @author Anatoly Chernysh
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        /*
        int [][]matrix = new int[3][4];
        matrix[0][0] = 1; matrix[0][1] = 3; matrix[0][2] = 5; matrix[0][3] = 7;
        matrix[1][0] = 10; matrix[1][1] = 11; matrix[1][2] = 16; matrix[1][3] = 20;
        matrix[2][0] = 23; matrix[2][1] = 30; matrix[2][2] = 34; matrix[2][3] = 50;
        System.out.println(searchMatrix(matrix, 3));
        */

        /*
        int [][]matrix = new int[3][4];
        matrix[0][0] = 1; matrix[0][1] = 3; matrix[0][2] = 5; matrix[0][3] = 7;
        matrix[1][0] = 10; matrix[1][1] = 11; matrix[1][2] = 16; matrix[1][3] = 20;
        matrix[2][0] = 23; matrix[2][1] = 30; matrix[2][2] = 34; matrix[2][3] = 50;
        System.out.println(searchMatrix(matrix, 13));
        */

        /*
        int matrix[][] = new int [1][2];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        System.out.println(searchMatrix(matrix, 1));
        */

        int matrix[][] = new int [2][1];
        matrix[0][0] = 1;
        matrix[1][0] = 3;
        System.out.println(searchMatrix(matrix, 1));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] == target;
        }

        int row = 0, lastColumn = matrix[0].length - 1;
        for (int i = 0;i < matrix.length;i++) {
            if (matrix[i][lastColumn] >= target) {
                row = i;
                break;
            }
        }

        int index = Arrays.binarySearch(matrix[row], target);
        return index >= 0;
    }

}
