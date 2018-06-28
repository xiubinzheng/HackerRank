package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anatoly Chernysh
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> combinations = new HashSet<>();
        makeCombination(candidates, target, 0, 0, "", combinations);
        return new ArrayList<>(combinations);
    }

    public void makeCombination(int[] candidates,
                                int target,
                                int currentIndex,
                                int currentSum,
                                String currentCombination,
                                Set<List<Integer>> allCombinations) {

        if (currentIndex < candidates.length) {
            for (int i = currentIndex;i < candidates.length;i++) {
                if (currentSum + candidates[i] < target) {
                    makeCombination(candidates, target, i,
                            currentSum + candidates[i],
                            currentCombination + "," + candidates[i],
                            allCombinations);
                }
                else if (currentSum  + candidates[i] == target) {
                    String []numbers = currentCombination.split(",");
                    List<Integer> newCombination = new ArrayList<>();
                    for (final String number : numbers) {
                        if (!number.isEmpty()) {
                            newCombination.add(Integer.valueOf(number));
                        }
                    }
                    newCombination.add(candidates[i]);
                    allCombinations.add(newCombination);
                }

            }
        }
    }
}
