package com.codility;

/**
 * @author Anatoly Chernysh
 */
public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        /*
        int []A = new int[8];
        A[0] = 3;
        A[1] = 2;
        A[2] = 6;
        A[3] = -1;
        A[4] = 4;
        A[5] = 5;
        A[6] = -1;
        A[7] = 2;
        */
        int []A = {6, 1, 5, 6, 4, 2, 9, 4};
        //int []A = {5, 5, 5};

        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        long maxDoubleSliceWithFirst = 0, maxDoubleSlice = 0;
        long currentMaxDoubleSlice = A[1];

        for (int i = 2;i < A.length - 1;i++) {
            maxDoubleSliceWithFirst = Math.max(currentMaxDoubleSlice, maxDoubleSliceWithFirst + A[i]);
            maxDoubleSlice = Math.max(maxDoubleSlice, maxDoubleSliceWithFirst);
            currentMaxDoubleSlice = Math.max(0, Math.max(A[i], currentMaxDoubleSlice + A[i]));
        }

        return (int)maxDoubleSlice;
    }
}
