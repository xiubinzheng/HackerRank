package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class MinimumSizeSubarraySum extends Base {
    public static void main(String[] args) {
        int []nums = {2, 3, 1, 2, 4, 3};
        //int []nums = {1, 1};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int minSize = 0;
        for (int i = 0;i < nums.length;i++) {
            int currentMinSize = 1, currSum = 0;
            for (int j = i;j < nums.length;j++) {
                currSum = currSum + nums[j];
                if (currSum >= s) {
                    break;
                }
                currentMinSize++;
            }
            if ((currentMinSize < minSize || minSize == 0) && currSum >= s) {
                minSize = currentMinSize;
            }
        }
        return minSize;
    }


}
