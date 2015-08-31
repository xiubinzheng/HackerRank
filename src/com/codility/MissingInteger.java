package com.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anatoly Chernysh

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.

For example, given:

A[0] = 1
A[1] = 3
A[2] = 6
A[3] = 4
A[4] = 1
A[5] = 2
the function should return 5.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 */
public class MissingInteger {

    public static void main(String[] args) {
        int []A = new int[1];

        A[0] = 1;

        System.out.println(solution(A));
    }

    /*
    public static int solution(int[] A) {
        Set setA = new HashSet<>();

        int permutationSum = 0;
        int givenSum = 0;
        int max = Integer.MIN_VALUE;

        int j = 0;
        for (int i = 0;i < A.length;i++) {
            if (A[i] > 0 && setA.add(A[i])) {
                max = Math.max(A[i], max);
                givenSum += A[i];
                permutationSum += j++ + 1;
            }
        }

        if (permutationSum == givenSum) {
            return max > 0 ? max + 1 : 1;
        }

        return Math.abs(max - Math.abs(permutationSum - givenSum));
    }
    */


    public static int solution(int[] A) {
        boolean marked[] = new boolean[A.length];

        for (int i = 0;i < A.length;i++) {
            if (A[i] > 0 && A[i] <= A.length) {
                marked[A[i] - 1] = true;
            }
        }

        for (int i = 0;i < marked.length;i++) {
            if (!marked[i]) {
                return i + 1;
            }
        }

        return marked.length + 1;
    }

}
