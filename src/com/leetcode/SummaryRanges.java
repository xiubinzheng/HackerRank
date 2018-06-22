package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class SummaryRanges {

    public static void main(String[] args) {
        //int nums[] = {0,1,2,4,5,7}; // 0-2, 2-5, 7
        //int nums[] = {0,1,2,4,5,6}; //
        int nums[] = {-2147483648,-2147483647,2147483647};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int current = 0;
        for (int i = 1;i < nums.length;i++) {
            if ((long)nums[i] - (long)nums[i - 1] > 1) {
                if (current == i - 1) {
                    result.add(String.valueOf(nums[current]));
                }
                else {
                    result.add(String.valueOf(nums[current]) + "->" + String.valueOf(nums[i - 1]));
                }
                current = i;
            }
        }
        if (current < nums.length - 1) {
            result.add(String.valueOf(nums[current]) + "->" + String.valueOf(nums[nums.length - 1]));
        }
        else {
            result.add(String.valueOf(nums[current]));
        }


        return result;
    }

}
