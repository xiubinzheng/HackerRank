package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RemoveDuplicatesFromSortedArray extends Base {

    public static void main(String[] args) {
        int []nums = {1, 1, 2, 2, 3, 4, 5, 7, 7};

        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
        dump(nums);
    }

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] > nums[j]) {
                nums[++j] = nums[i];
            }
        }

        return j + 1;
    }


}
