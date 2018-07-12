package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }

        int odd = nums[0], even = nums[1];

        for (int i = 2;i < nums.length;i++) {
            if (i % 2 == 0) {
                if (even < odd) {
                    even = odd;
                }
                odd += nums[i];
            }
            else {
                if (odd < even) {
                    odd = even;
                }
                even += nums[i];
            }
        }
        return Math.max(odd, even);
    }
}
