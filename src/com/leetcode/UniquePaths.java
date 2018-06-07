package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        int []row = new int[m];
        for (int i = 0;i < m;i++) {
            row[i] = 1;
        }

        for (int i = 1;i < n;i++) {
            for (int j = 1;j < m;j++) {
                row[j] = row[j] + row[j - 1];
            }
        }

        return row[m - 1];
    }
}
