package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anatoly Chernysh
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mapping = new HashMap<>();
        int maxElement = nums[0], maxCount = Integer.MIN_VALUE;

        for (int i = 0;i < nums.length;i++) {
            Integer value = mapping.get(nums[i]);
            int current = 1;

            if (value == null) {
                mapping.put(nums[i], current);
            }
            else {
                current = value + 1;
                mapping.put(nums[i], current);
            }

            if (current > maxCount) {
                maxCount = current;
                maxElement = nums[i];
            }
        }

        return maxElement;
    }
}
