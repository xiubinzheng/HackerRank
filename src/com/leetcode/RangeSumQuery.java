package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RangeSumQuery {

    private int[] nums;

    private int[]sums;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length + 1];

        for (int i = 0;i < nums.length;i++) {
            this.sums[i + 1] = this.sums[i] + this.nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        int []nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery rangeSumQuery = new RangeSumQuery(nums);
        System.out.println(rangeSumQuery.sumRange(0, 2));
        System.out.println(rangeSumQuery.sumRange(2, 5));
        System.out.println(rangeSumQuery.sumRange(0, 5));
    }
}
