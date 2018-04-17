package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int []nums = {1,3,5,6};
        int target = 0;
        System.out.println(searchInsert(nums, target));

    }

    public static int searchInsert(int[] nums, int target) {
        int index = searchInsertHelper(nums, 0, nums.length, target);
        if (nums[index] == target) {
            return index;
        }
        if (target < nums[index]) {
            for (int i = index; i >= 0;i--) {
                if (nums[i] == target || nums[i] < target) {
                    return i;
                }
            }
            return 0;
        }
        else {
            for (int i = index; i < nums.length; i++) {
                if (nums[i] == target || nums[i] > target) {
                    return i;
                }
            }
            return nums.length;
        }
    }

    public static int searchInsertHelper(int[] nums, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (start == end) {
            return mid;
        }
        if (target > nums[mid]) {
            return searchInsertHelper(nums, mid, end - 1, target);
        }
        else {
            return searchInsertHelper(nums, start, mid, target);
        }
    }

}
