package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class FindPeakElement extends Base {
    
    public static void main(String[] args) {
        // 2
        //int nums[] = {1, 2, 3, 1};

        // 3
        //int nums[] = {1, 2, 3};

        // 0
        //int nums[] = {1};

        int nums[] = {1, 2};
        // 1

        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        for (int i = 1;i < nums.length;i++) {
            if ((i + 1 == nums.length || nums[i] > nums[i + 1]) &&
                    nums[i] > nums[i - 1]) {
                return i;
            }
        }

        return 0;
    }
}
