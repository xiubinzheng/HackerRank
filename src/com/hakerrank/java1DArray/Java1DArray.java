package com.hakerrank.java1DArray;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class Java1DArray {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int amountTestCases = Integer.parseInt(in.nextLine());

        for (int i = 0;i < amountTestCases;i++) {
            String gameParams = in.nextLine();
            String parsedGameParams[] = gameParams.split(" ");
            int boardSize = Integer.parseInt(parsedGameParams[0]);
            int maxJump = Integer.parseInt(parsedGameParams[1]);

            int board[] = new int[boardSize];
            String boardParams = in.nextLine();
            String parsedBoardParams[] = boardParams.split(" ");

            int j = 0;
            for (String boardItem : parsedBoardParams) {
                board[j++] = Integer.parseInt(boardItem);
            }

            System.out.println(playGame(board, 0, maxJump, 0) ? "YES" : "NO");
        }
    }

    private static boolean playGame(int []board, int start, int maxJump, int prev) {
        boolean isWin = false;
        int i = start;

        for (;;) {

            if (i + maxJump > board.length - 1) {
                isWin = true;
                break;
            }
            else if (board[i + maxJump] == 0) {
                i = i + maxJump;
            }
            else if (board[i + 1] == 0) {
                i = i + 1;
            }
            else {
                if (board[start + 1] == 0) {
                    if (playGame(board, start + 1, maxJump, start)) {
                        isWin = true;
                    }
                }
                else if (board[start + maxJump] == 0) {
                    if (playGame(board, start + maxJump, maxJump, start)) {
                        isWin = true;
                    }
                }
                else if (start - 1 >= 0 && board[start - 1] == 0 && (start - 1) != prev) {
                    for (int j = start - 1; ;j--) {
                        if (j >= 0 && board[j] == 0) {
                            if (playGame(board, j, maxJump, j + 1)) {
                                isWin = true;
                            }
                            break;
                        }
                        else {
                            break;
                        }
                    }
                }

                break;
            }
        }

        return isWin;
    }
}
