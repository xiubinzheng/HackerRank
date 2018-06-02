package com.leetcode;

import java.util.Arrays;

/**
 * @author Anatoly Chernysh
 */
public class KthSmallestInMatrix {

    public static void main(String[] args) {
        {
            int[][] matrix = {
                    {1, 2},
                    {1, 3}};
            int k = 4;
            System.out.println(kthSmallest(matrix, k));
        }


        {
            int[][] matrix = {
                    {1, 5, 9},
                    {10, 11, 13},
                    {12, 13, 15}};
            int k = 8;
            System.out.println(kthSmallest(matrix, k));
        }

        {
            int[][] matrix = {{-5}};
            int k = 1;
            System.out.println(kthSmallest(matrix, k));
        }

        {
            int[][] matrix = {
                    {1, 2},
                    {1, 3}};
            int k = 2;
            System.out.println(kthSmallest(matrix, k));
        }

    }

    public static int kthSmallest(int[][] matrix, int k) {
        int []sorted = new int[matrix.length * matrix.length];
        int dest = 0;
        for (int i = 0;i < matrix.length;i++){
            System.arraycopy(matrix[i], 0, sorted, dest, matrix[i].length);
            dest += matrix[i].length;
        }

        Arrays.sort(sorted);
        return sorted[k - 1];
    }

}
