package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
        //System.out.println(guessNumber(1));
    }

    public static int guess(int num) {
        if (num == 6) {
            return 0;
        }
        else if (num > 6) {
            return -1;
        }
        else {
            return 1;
        }
    }
    /*
    public static int guess(int num) {
        if (num == 1) {
            return 0;
        }
        else if (num > 1) {
            return -1;
        }
        else {
            return 1;
        }
    }
    */


    public static int guessNumber(int n) {
        int lo = 0, hi = n;
        while (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            }
            else if (result == 1) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }

        return -1;
    }

}
