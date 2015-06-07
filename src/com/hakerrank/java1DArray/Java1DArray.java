package com.hakerrank.java1DArray;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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

            System.out.println(playGame(board, 0, maxJump) ? "YES" : "NO");
        }
    }

    private static boolean playGame(int []board, int start, int maxJump) {
        boolean isWin = false;
        int i = start;

        Stack<Integer> candidates = new Stack<Integer>();
        List<Integer> visited = new ArrayList<Integer>();

        for (;;) {

            if (i + maxJump > board.length - 1) {
                isWin = true;
                break;
            }
            else if (board[i + maxJump] == 0) {
                i = i + maxJump;

                for (int j = i; j > i - maxJump; j--) {
                    int temp = j - 1;
                    if (temp >= 0 && board[temp] == 0) {
                        if (!visited.contains(temp)) {
                            candidates.push(temp);
                            visited.add(temp);
                        }
                    }
                    else {
                        break;
                    }
                }

                for (int j = i - maxJump; j < board.length; j++) {
                    int temp = j;
                    if (temp >= 0 && board[temp] == 0) {
                        if (!visited.contains(temp)) {
                            candidates.push(temp);
                            visited.add(temp);
                        }
                    }
                    else {
                        break;
                    }
                }

            }
            else if (board[i + 1] == 0) {
                i = i + 1;
            }
            else {
                if (candidates.isEmpty()) {
                    break;
                }
                i = candidates.pop();
            }
        }

        return isWin;
    }
}
