package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        System.out.println(numTrees(18));
    }

    public static int numTrees(int n) {
        int []dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i <= n;i++) {
            for (int j = 1;j <= i;j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }


    /*
    public static int numTrees(int n) {
        return trees(1, n);
    }

    public static int trees(int lo, int hi) {
        if (lo >= hi) {
           return 1;
        }

        int total = 0;
        for (int i = lo;i <= hi;i++) {
            total += trees(lo, i - 1) * trees(i + 1, hi);
        }

        return total;
    }
    */

}
