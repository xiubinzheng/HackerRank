package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class TwoSum {

    public static void main(String[] args) {
        /*
        int []nums = {7, 14, 11, 15, 2};
        int target = 9;
        */

        int []nums = {3, 2, 4};
        int target = 6;


        int []result = twoSum(nums, target);
        System.out.println(result[0] + " : " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int []result = new int[2];

        for (int i = 0;i < nums.length;i++) {
            for (int j = 0;j < nums.length;j++) {
                if ((nums[i] + nums[j] == target) && i != j) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

}
