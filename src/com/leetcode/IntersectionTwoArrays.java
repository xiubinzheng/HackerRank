package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anatoly Chernysh
 */
public class IntersectionTwoArrays extends Base {

    public static void main(String[] args) {
        int []nums1 = {1, 2, 2, 1, 3, 5, 6};
        int []nums2 = {2, 2, 3};
        int []result = intersection(nums1, nums2);
        dump(result);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }

        int []result = new int[intersection.size()];
        int i = 0;
        for (Integer num  : intersection) {
            result[i++] = num;
        }
        return result;
    }
}
