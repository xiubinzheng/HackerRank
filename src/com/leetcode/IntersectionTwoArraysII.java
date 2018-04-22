package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class IntersectionTwoArraysII extends Base {

    public static void main(String[] args) {
        int []nums1 = {1};
        int []nums2 = {1, 1};
        int []result = intersect(nums1, nums2);
        dump(result);

        /*
        int []nums1 = {3, 1, 2};
        int []nums2 = {1, 1};
        int []result = intersect(nums1, nums2);
        dump(result);
        */

        /*
        int []nums1 = {2, 1};
        int []nums2 = {1, 2};
        int []result = intersect(nums1, nums2);
        dump(result);
        */
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        List<Integer> intersection = new ArrayList<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        for (;;) {
            if (set1.isEmpty() || set2.isEmpty()) {
                break;
            }
            for (;;) {
                if (set2.isEmpty()) {
                    break;
                }
                int num = set2.get(0);
                if (set1.contains(num)) {
                    intersection.add(num);
                    set1.remove((Integer)num);
                }
                set2.remove((Integer)num);
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
