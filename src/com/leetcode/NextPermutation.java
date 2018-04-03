package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class NextPermutation extends Base {

    public static void main(String[] args) {
        //int []nums = {1,2,3};
        //int []nums = {1,1,5};
        //int []nums = {1,3,2};
        //int []nums = {2,3,1};
        //int []nums = {4,2,0,2,3,2,0};
        //int []nums = {1};
        int []nums = {1, 2};
        //int []nums = {3, 2, 1};
        nextPermutation(nums);
        dump(nums);
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void swap(int []nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int []nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
