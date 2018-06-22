package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class TwoSumIIInputArraySorted {

    public static void main(String[] args) {
        //int []numbers = {1,2,7,11,12,15}; // 9
        int []numbers = {2,7,11,15};

        int []result = twoSum(numbers, 9);
        for (int value : result) {
            System.out.println(value);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
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
        result[0] = lo + 1;
        result[1] = hi + 1;
        return result;
    }
}
