package com.amazon;

/**
 * @author Anatoly Chernysh
 *
 *
Jhon plays a game in which he throws a baseball at various blocks marked with a symbol so as to knock these out. A core is computed for each throw. The “last score” is the score of the previous throw (or 0, if there is no previous throw) and the total score is the sum of the scores of all the throws. The symbol on a block can be an integer, a sing or a letter. Each sing or letter represents a special rule as given below:

If a throw hits a block marked with an integer, the score for that throw is the value of that integer.
If a throw hits a block marked with an “X”, the score for that throw is double the last score.
If a throw hits a block marked with a “+”, the score for that throw is the sum of the last two scores.
If a throw hits a block marked with a “Z”, the last score is removed, as though the last throw never happened. Its value does not count towards the total score, and the subsequent throws will ignore it when computing their values (see example below).

Write an algorithm that computes the total score for a given list of ordered hits by john.

Input
The input to the function/method consists of two arguments. Blocks, representing a list of symbols and n, an integer representing the number of symbols in the list.

Output
Return an integer representing the total score for the given list of ordered hits.

Example
Input:
blocks=[5,-2,4,Z,X,9,+,+],n=8

Output:
27

Explanition:
After the block marked with 5 is hit, the current score  is 5 and the total score is 5.
After the block marked with -2 is hit, the current score  is -2 and the total score is 3.
After the block marked with 4 is hit, the current score  is 4 and the total score is 7.
After the block marked with “Z” is hit, the previous throw never happened, so the total score goes back to 3.
After the block marked with “X” is hit, the current score  is 2*-2=-4 and the total score is -1.(remember, throws after a Z ignore the removed score when computing their values).
After the block marked with 9 is hit, the current score  is 9 and the total score is 8.
After the block marked with “+” is hit, the current score  is -4+9=5 and the total score is 13.
After the block marked with “+” is hit, the current score  is 9+5=14 and the total score is 27.

 */
public class Amazon_1 {

    public static void main(String[] args) {
        // 27
        //String[] blocks = {"5", "-2", "4", "Z", "X", "9", "+", "+"};

        String[] blocks = {"5", "-2", "4", "Z", "X", "9", "+", "+", "4", "5", "Z", "Z"};

        /*
        int []scoreHistory = new int[blocks.length];
        Arrays.fill(scoreHistory, Integer.MIN_VALUE);
        System.out.println("Result: " + calculateScore(blocks, blocks.length, 0, 0, scoreHistory));
        */
        Amazon_1 amazon_1 = new Amazon_1();
        System.out.println(amazon_1.totalScore(blocks, blocks.length));
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

    private int totalScore = 0;
    private int currentScore = 0;
    private int tmpBeforeCurrentScore = 0;
    private int beforeCurrentScore = 0;

    public int totalScore(String[] blocks, int n) {
        for (int i = 0;i< blocks.length;i++) {
            if (isInteger(blocks[i])) {
                continue;
            }
            if (isX(blocks[i])) {
                continue;
            }
            if (isPlus(blocks[i])) {
                continue;
            }
            if (isZ(blocks[i])) {
                continue;
            }
        }
        return totalScore;
    }

    private boolean isInteger(String block) {
        try {
            int tmpCurrentScore = Integer.parseInt(block);
            tmpBeforeCurrentScore = beforeCurrentScore;
            beforeCurrentScore = currentScore;
            currentScore = tmpCurrentScore;
            totalScore += currentScore;
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    private boolean isX(String block) {
        if (block.equals("X")) {
            tmpBeforeCurrentScore = beforeCurrentScore;
            beforeCurrentScore = currentScore;
            currentScore = currentScore * 2;
            totalScore += currentScore;
            return true;
        }
        return false;
    }

    private boolean isPlus(String block) {
        if (block.equals("+")) {

            tmpBeforeCurrentScore = beforeCurrentScore;
            int tmp = currentScore;
            currentScore = currentScore + beforeCurrentScore;
            totalScore += currentScore;
            beforeCurrentScore = tmp;
            return true;
        }
        return false;
    }

    private boolean isZ(String block) {
        if (block.equals("Z")) {
            totalScore -= currentScore;
            currentScore = beforeCurrentScore;
            beforeCurrentScore = tmpBeforeCurrentScore;
            return true;
        }
        return false;
    }

}
