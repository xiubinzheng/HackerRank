package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class MissingNumber {
    public static void main(String[] args) {
        //int []nums = {9,6,4,2,3,5,7,0,1};
        //int []nums = {3, 0, 1};
        int []nums = {1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        long expectedSum = nums.length * (nums.length + 1) / 2;
        long currentSum = 0;
        for (int num  : nums) {
            currentSum += num;
        }
        return (int)(expectedSum - currentSum);
    }
}
