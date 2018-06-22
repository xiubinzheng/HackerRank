package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0;i < nums.length;i++) {
            final List<Integer> perm = new ArrayList<>();
            perm.add(nums[i]);
            result.add(perm);

            permutations(nums, i + 1, perm, result);
        }

        return result;
    }

    private void permutations(int[] nums, int startIndex, List<Integer> current, List<List<Integer>> result) {
        if (startIndex < nums.length) {
            for (int i = startIndex;i < nums.length;i++) {
                List<Integer> perm = new ArrayList<>(current);
                perm.add(nums[i]);
                result.add(perm);
                permutations(nums, i + 1, perm, result);
            }
        }
    }
}
