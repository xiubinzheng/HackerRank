package com.leetcode;

import java.util.Arrays;

/**
 * @author Anatoly Chernysh
 */
public class SearchForRange {

    public static void main(String[] args) {
        int []nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        //int []nums = {5,7,7,8,8,10};
        //int target = 6;

        //int []nums = {2, 2};
        //int target = 2;


        //int []nums = {1, 3};
        //int target = 1;

        //int []nums = {3, 3, 3};
        //int target = 3;


        int []range = searchRange(nums, target);
        System.out.println(range[0] + " = " + range[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 1 && target == nums[0]) {
            return new int[] {0, 0};
        }

        int []range = {-1, -1};

        int start = Arrays.binarySearch(nums, 0, nums.length, target), end = start;
        if (start < 0) {
            return range;
        }

        for (int i = start + 1;i < nums.length;i++) {
            if (nums[i] == target) {
                end++;
            }
            else {
                break;
            }
        }

        for (int i = start - 1;i >= 0;i--) {
            if (nums[i] == target) {
                start--;
            }
            else {
                break;
            }
        }

        range[0] = start;
        range[1] = end;

        return range;
    }
}
