package com.experitest;

/**
 * @author Anatoly Chernysh
 */
public class SpiralFormMatrix {

    public static void main(String[] args) {
        int [][]matrix = new int[4][4];
        for (int i = 0;i < matrix[0].length;i++) {
            for (int j = 0;j < matrix.length;j++) {
                matrix[i][j] = j + 1 + i * matrix[0].length;
            }
        }

        printMatrix(matrix);
        printSpiralFormMatrix(matrix);
    }

    public static void printMatrix(int [][]matrix) {
        for (int i = 0;i < matrix[0].length;i++) {
            for (int j = 0;j < matrix.length;j++) {
                System.out.print(String.format("%3d", matrix[i][j]));
            }
            System.out.println();
        }

    }

    public static void printSpiralFormMatrix(int [][]matrix) {
        int startRow = 0, endRow = matrix.length;
        int startColumn = 0, endColumn = matrix[0].length;

        System.out.println();
        System.out.println("Spiral form of matrix: ");

        while (startRow < endRow && startColumn < endColumn) {
            for (int i = startColumn;i < endColumn;i++) {
                System.out.printf(String.format("%3d", matrix[startRow][i]));
            }
            startRow++;

            for (int i = startRow;i < endRow;i++) {
                System.out.printf(String.format("%3d", matrix[i][endColumn - 1]));
            }
            endColumn--;

            if (startColumn < endColumn) {
                for (int i = endColumn - 1; i >= startColumn; i--) {
                    System.out.printf(String.format("%3d", matrix[endRow - 1][i]));
                }
                endRow--;
            }

            if (startRow < endRow) {
                for (int i = endRow - 1; i >= startRow; i--) {
                    System.out.printf(String.format("%3d", matrix[i][startColumn]));
                }
                startColumn++;
            }
        }

    }
}
