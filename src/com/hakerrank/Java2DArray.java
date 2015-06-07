package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class Java2DArray {

    public static void main(String []args)  {
        Scanner in = new Scanner(System.in);

        int [][]board = new int[6][6];
        for (int i = 0;i < board.length;i++) {
            String line = in.nextLine();
            String parsedLine[] = line.split(" ");

            for (int j = 0;j < board[i].length;j++) {
                board[i][j] = Integer.parseInt(parsedLine[j]);
            }
        }

        System.out.println(calculateMaxSumForHourglasses(board));
    }

    private static int calculateMaxSumForHourglasses(int [][]board) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < board.length - 2;i++) {
            for (int j = 0;j < board[i].length - 2;j++) {
                int sum = calculateSumForHourglass(board, i, j);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    private static int calculateSumForHourglass(int [][]board, int i, int j) {
        int sum = Integer.MIN_VALUE;

        if (j < board[i].length - 2 || i < board.length - 2) {
            sum = board[i][j] + board[i][j + 1] + board[i][j + 2] +
                    board[i + 1][j + 1] +
                    board[i + 2][j] + board[i + 2][j + 1] + board[i + 2][j + 2];
        }

        return sum;
    }
}
