package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class UniquePaths2 {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[3][3];
        obstacleGrid[0] = new int[3];
        obstacleGrid[0][0] = 0;
        obstacleGrid[0][1] = 0;
        obstacleGrid[0][2] = 0;

        obstacleGrid[1] = new int[3];
        obstacleGrid[1][0] = 0;
        obstacleGrid[1][1] = 1;
        obstacleGrid[1][2] = 0;

        obstacleGrid[2] = new int[3];
        obstacleGrid[2][0] = 0;
        obstacleGrid[2][1] = 0;
        obstacleGrid[2][2] = 0;

        System.out.println(uniquePathsWithObstacles(obstacleGrid));

        int [][]arr = new int[1][1];
        arr[0] = new int[1];
        arr[0][0] = 1;
        System.out.println(uniquePathsWithObstacles(arr));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int []row = new int[obstacleGrid[0].length];
        row[0] = 1;

        for (int i = 0;i < obstacleGrid.length;i++) {
            for (int j = 0;j < obstacleGrid[0].length;j++) {
                if (obstacleGrid[i][j] == 1) {
                    row[j] = 0;
                }
                else if (j > 0) {
                    row[j] = row[j] + row[j - 1];
                }
            }
        }

        return row[obstacleGrid[0].length - 1];
    }

}
