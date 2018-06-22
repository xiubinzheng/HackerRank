package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        //int []nums = {2,3,-2,4};
        //int []nums = {-2, 0, -1};
        //int []nums = {-2,3,-4};
        //int []nums = {3,-1,4};
        int []nums = {2,-5,-2,-4,3};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int maxLeft = nums[0], maxRight = nums[nums.length - 1];

        int multiply = maxLeft;
        for (int i = 1;i < nums.length;i++) {
            if (multiply == 0) {
                multiply = 1;
            }
            multiply *= nums[i];
            if (multiply > maxLeft) {
                maxLeft = multiply;
            }
        }

        multiply = maxRight;
        for (int i = nums.length - 2;i >= 0;i--) {
            if (multiply == 0) {
                multiply = 1;
            }
            multiply *= nums[i];
            if (multiply > maxRight) {
                maxRight = multiply;
            }
        }

        return Math.max(maxLeft, maxRight);
    }}
