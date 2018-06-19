package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class NumberOneBits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }

        return sum;
    }


}
