package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anatoly Chernysh
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        //System.out.println(containsNearbyDuplicate(new int[] {-1, -1}, 1));
        //System.out.println(containsNearbyDuplicate(new int[] {1, 2}, 2));
        //System.out.println(containsNearbyDuplicate(new int[] {2, 2}, 3));

        System.out.println(containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < nums.length;i++) {
            if (!set.add(nums[i])) {
                int from = (i - k) < 0 ? 0 : i - k;
                for (int j = from;j < i;j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
