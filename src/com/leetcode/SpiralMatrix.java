package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        /*
        int [][]matrix = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 2, 2, 2, 2, 2, 1},
                {1, 2, 3, 3, 3, 2, 1},
                {1, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1}};
               */

        /*
        int [][]matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        */

        int [][]matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        /*
        int [][]matrix = {
                {2,5},
                {8,4},
                {0,-1}};
                */

        /*
        int [][]matrix = {{2,5,8},
                {4,0,-1}};
                */

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.EMPTY_LIST;
        }

        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;

        List<Integer> result = new ArrayList<Integer>();


        while (r1 <= r2 && c1 <= c2) {

            // top
            for (int j = c1;j <= c2;j++) {
                result.add(matrix[r1][j]);
            }
            r1++;

            // right
            for (int i = r1;i <= r2;i++) {
                result.add(matrix[i][c2]);
            }
            c2--;

            if (r1 <= r2 && c1 <= c2) {
                // bottom
                for (int j = c2; j >= c1; j--) {
                    result.add(matrix[r2][j]);
                }
                r2--;

                // left
                for (int i = r2; i >= r1; i--) {
                    result.add(matrix[i][c1]);
                }
                c1++;
            }
        }

        return result;
    }

}
