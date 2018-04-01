package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ThreeSumClosest extends Base {
    public static void main(String[] args) {
        int []S = {-1, 2, 1, -4};
        int target = 1;

        //int []S = {1, 1, 1, 0};
        //int target = -100;

        //int []S = {1, 1, -1, -1, 3};
        //int target = -1;

        //int []S = {-3,-2,-5,3,-4};
        //int target = -1;

        System.out.println(threeSumClosest(S, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;

        for (int i = 0;i < nums.length;i++) {
            int sum1 = nums[i];
            if (i + 1 < nums.length) {
                for (int j = i + 1;j < nums.length;j++) {
                    int sum2 = sum1 + nums[j];
                    if (j + 1 < nums.length) {
                        for (int k = j + 1;k < nums.length;k++) {
                            int sum3 = sum2 + nums[k];
                            if (sum3 == target) {
                                return target;
                            }
                            if ((Math.abs(target - sum3) < Math.abs(target - closestSum)) || closestSum == Integer.MAX_VALUE) {
                                closestSum = sum3;
                            }
                        }
                    }
                }
            }
        }

        return closestSum;
    }
}
