package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anatoly Chernysh
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int []nums = {100, 4, 200, 1, 3, 2};
        //int []nums = {0, -1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        final Set<Integer> hashedNums = new HashSet<>();
        for (int num : nums) {
            hashedNums.add(num);
        }

        int longestConsecutive = 0;

        for (Integer hashedNum : hashedNums) {
            int currentLongestConsecutive = 1;
            if (!hashedNums.contains(hashedNum - 1)) {
                while (hashedNums.contains(++hashedNum)) {
                    currentLongestConsecutive++;
                }
            }
            if (currentLongestConsecutive > longestConsecutive) {
                longestConsecutive = currentLongestConsecutive;
            }
        }

        return longestConsecutive;
    }

}
