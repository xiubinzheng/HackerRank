package com.leetcode;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);

        for (int i = 0;i < nums.length;i++) {
            final List<Integer> perm = new ArrayList<>();
            perm.add(nums[i]);
            result.add(perm);

            permutations(nums, i + 1, perm, result);
        }

        return new ArrayList(result);
    }

    private void permutations(int[] nums, int startIndex, List<Integer> current, Set<List<Integer>> result) {
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
