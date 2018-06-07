package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        /*
        int [][]grid = new int[3][3];

        grid[0] = new int[3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;

        grid[1] = new int[3];
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;

        grid[2] = new int[3];
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        System.out.println(minPathSum(grid));
        */

        int [][]grid = new int[2][3];

        grid[0] = new int[3];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 5;

        grid[1] = new int[3];
        grid[1][0] = 3;
        grid[1][1] = 2;
        grid[1][2] = 1;

        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid) {
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++) {
                if (i > 0 && j > 0) {
                    grid[i][j] += (grid[i - 1][j] > grid[i][j - 1] ? grid[i][j - 1] : grid[i - 1][j]);
                }
                else if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                else if (i > 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }


}
