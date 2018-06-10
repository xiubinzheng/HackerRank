package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RangeSumQuery2D {

    int [][]sums;

    public RangeSumQuery2D(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        sums = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0;i < sums.length;i++) {
            for (int j = 0;j < matrix[i].length;j++) {
                sums[i][j + 1] = sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1;i <= row2;i++) {
            sum += (sums[i][col2 + 1] - sums[i][col1]);
        }

        return sum;
    }


    public static void main(String[] args) {
        int [][]matrix = new int[5][5];

        matrix[0] = new int[5];
        matrix[0][0] = 3; matrix[0][1] = 0; matrix[0][2] = 1; matrix[0][3] = 4; matrix[0][4] = 2;

        matrix[1] = new int[5];
        matrix[1][0] = 5; matrix[1][1] = 6; matrix[1][2] = 3; matrix[1][3] = 2; matrix[1][4] = 1;

        matrix[2] = new int[5];
        matrix[2][0] = 1; matrix[2][1] = 2; matrix[2][2] = 0; matrix[2][3] = 1; matrix[2][4] = 5;

        matrix[3] = new int[5];
        matrix[3][0] = 4; matrix[3][1] = 1; matrix[3][2] = 0; matrix[3][3] = 1; matrix[3][4] = 7;

        matrix[4] = new int[5];
        matrix[4][0] = 1; matrix[4][1] = 0; matrix[4][2] = 3; matrix[4][3] = 0; matrix[4][4] = 5;

        RangeSumQuery2D rangeSumQuery2D = new RangeSumQuery2D(matrix);
        System.out.println(rangeSumQuery2D.sumRegion(2, 1, 4, 3));
        System.out.println(rangeSumQuery2D.sumRegion(1, 1, 2, 2));
        System.out.println(rangeSumQuery2D.sumRegion(1, 2, 2, 4));
    }

}
