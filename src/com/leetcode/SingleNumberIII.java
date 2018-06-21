package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;

        int []result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            }
            else {
                result[1] ^= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(3 ^ 5));

        int []nums = {1,2,1,3,2,5};
        int []result = singleNumber(nums);
        for (int value : result) {
            System.out.println(value);
        }
    }
}
