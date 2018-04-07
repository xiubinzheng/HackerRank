package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class FindMinimumRotatedSortedArray {

    public static void main(String[] args) {
        //int []nums = {2,3,4,5,1};
        //int []nums = {4, 5, 6, 7, 0, 1, 2};
        //int []nums = {2,3,1};
        //int []nums = {6,1,2,3,4,5};
        //int []nums = {4,5,6,7,8,9,1,2,3};
        //int []nums = {6,7,8,1,2,3,4,5};
        int []nums = {284,287,289,293,295,298,0,3,8,9,10,11,12,15,17,19,20,22,26,29,30,31,35,36,37,38,42,43,45,50,51,54,56,58,59,60,62,63,68,70,73,74,81,83,84,87,92,95,99,101,102,105,108,109,112,114,115,116,122,125,126,127,129,132,134,136,137,138,139,147,149,152,153,154,155,159,160,161,163,164,165,166,168,169,171,172,174,176,177,180,187,188,190,191,192,198,200,203,204,206,207,209,210,212,214,216,221,224,227,228,229,230,233,235,237,241,242,243,244,246,248,252,253,255,257,259,260,261,262,265,266,268,269,270,271,272,273,277,279,281};

        FindMinimumRotatedSortedArray findMinimumRotatedSortedArray = new FindMinimumRotatedSortedArray();
        System.out.println(findMinimumRotatedSortedArray.findMin(nums));
    }

    public int findMin(int[] nums) {
        int midValue = nums[nums.length / 2];

        int leftValue = findMinHelper(0, nums.length, nums);
        int rightValue = findMinHelper(0, nums.length, nums);

        return Math.min(Math.min(midValue, leftValue), rightValue);
    }

    /**
     * Very very bad...but works.
     */
    public int findMinHelper(int start, int end, int []nums) {
        int mid = start + (end - start) / 2;
        int midValue = nums[mid];

        int leftValue = Integer.MAX_VALUE;
        if (mid - 1 >= start) {
            if (mid - start == 2 && start >= 0) {
                leftValue = Math.min(nums[mid - 1], nums[start]);
            }
            else if (nums[mid - 1] >= nums[start]) {
                leftValue = nums[start];
            }
            else {
                leftValue = findMinHelper(start, mid - 1, nums);
            }
        }
        int rightValue = Integer.MAX_VALUE;

        if (mid + 1 <= end && end - 1 >= 0 && mid + 1 < nums.length) {
            if (end - mid == 2 && end < nums.length) {
                rightValue = Math.min(nums[mid + 1], nums[end]);
            }
            else if ((end == nums.length && nums[mid + 1] <= nums[end - 1]) ||
                    (end != nums.length && nums[mid + 1] <= nums[end])) {
                rightValue = nums[mid + 1];
            }
            else {
                rightValue = findMinHelper(mid + 1, end, nums);
            }
        }
        return Math.min(Math.min(midValue, leftValue), rightValue);
    }

}
