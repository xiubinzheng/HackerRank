package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class TwoSumIIInputArraySorted {

    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo <= hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                hi--;
            }
            else {
                lo++;
            }
        }

        int result[] = new int[2];
        result[0] = lo;
        result[1] = hi;
        return result;
    }
}
