package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }


    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, 0, k - 1, new ArrayList<>(), 0, n, result);
       return result;
    }

    public static void helper(int index,
                              int level,
                              int maxLevel,
                              List<Integer> combination,
                              int combinationSum,
                              int target,
                              List<List<Integer>> result) {
        for (int i = index;i <= 9;i++) {
            if (level == maxLevel) {
                if (combinationSum + i > target) {
                    return;
                }
                else if (combinationSum + i == target) {
                    List<Integer> newCombination = new ArrayList<>(combination);
                    newCombination.add(i);
                    result.add(newCombination);
                }
            }
            else {
                combination.add((Integer)i);
                helper(i + 1, level + 1, maxLevel, combination, combinationSum + i, target, result);
                combination.remove((Integer)i);
            }
        }
    }
}
