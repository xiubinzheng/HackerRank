package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left <= right) {
            maxArea = Math.max((right - left) * Math.min(height[left], height[right]), maxArea);
            if (height[left] > height[right]) {
                right--;
            }
            else {
                left++;
            }
        }

        return maxArea;
    }

}
