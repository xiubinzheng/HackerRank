package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class SingleNumber {

    public static void main(String[] args) {
        /*
        int []arr = {2, 2, 1};
        System.out.println(singleNumber(arr));
        */

        int []arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int missingNumber = 0;
        for (int num : nums) {
            missingNumber ^= num;
        }

        return missingNumber;
    }

}
