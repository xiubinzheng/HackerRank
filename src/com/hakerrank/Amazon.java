package com.hakerrank;

import java.util.Arrays;

/**
 * @author Anatoly Chernysh
 */
public class Amazon {

  public static void main(String[] args) {
    // 27
    String[] blocks = {"5", "-2", "4", "Z", "X", "9", "+", "+"};

    int []scoreHistory = new int[blocks.length];
    Arrays.fill(scoreHistory, Integer.MIN_VALUE);
    System.out.println("Result: " + calculateScore(blocks, blocks.length, 0, 0, scoreHistory));
  }

  public static int calculateScore(String[] blocks, int n, int i, int totalScore, int []scoreHistory) {
    if (i >= n) {
      return totalScore;
    }

    if (blocks[i].equalsIgnoreCase("Z")) {
      int curr = 0;
      if (i - 1 > 0) {
        curr = scoreHistory[i - 1];
        scoreHistory[i] = scoreHistory[i - 1] = i - 2 >= 0 ? scoreHistory[i - 2] : 0;
      }
      else {
        scoreHistory[i] = 0;
      }
      return calculateScore(blocks, n, i + 1, totalScore - curr, scoreHistory);
    }
    if (blocks[i].equalsIgnoreCase("X")) {
      if (i - 1 > 0) {
        scoreHistory[i] = scoreHistory[i - 1] * 2;
      }
      else {
        scoreHistory[i] = 0;
      }
      return calculateScore(blocks, n, i + 1, totalScore + scoreHistory[i], scoreHistory);

    }
    if (blocks[i].equalsIgnoreCase("+")) {
      if (i - 2 >= 0) {
        scoreHistory[i] = scoreHistory[i - 2] + scoreHistory[i - 1];
      }
      else if (i - 1 >= 0) {
        scoreHistory[i] = scoreHistory[i - 1];
      }
      else {
        scoreHistory[i] = 0;
      }
      return calculateScore(blocks, n, i + 1, totalScore + scoreHistory[i], scoreHistory);
    }

    scoreHistory[i] = Integer.valueOf(blocks[i]);
    return calculateScore(blocks, n, i + 1, totalScore + Integer.valueOf(blocks[i]), scoreHistory);
  }


}
