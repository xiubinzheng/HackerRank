package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class WordSearch {

    public static void main(String[] args) {
        char [][]board = {{'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                if (search(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean search(char[][] board, String word, int index, int row, int column) {
        if (row < board.length && column < board[0].length && row >= 0 && column >= 0 && index < word.length()) {
            if (word.length() - 1 == index &&
                    word.charAt(index) == board[row][column]) {
                return true;
            }
            if (word.charAt(index++) == board[row][column]) {
                char tmp = board[row][column];
                board[row][column] = '#';

                boolean result = search(board, word, index, row + 1, column) || search(board, word, index, row - 1, column) ||
                        search(board, word, index, row, column + 1) || search(board, word, index, row, column - 1);

                board[row][column] = tmp;

                return result;

            }
        }
        return false;
    }

}
