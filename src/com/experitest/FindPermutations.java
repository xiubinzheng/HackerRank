package com.experitest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anatoly Chernysh
 */
public class FindPermutations {

    private Set<List<Integer>> allPermutations = new HashSet<>();

    public static void main(String[] args) {
        int n = 4;

        FindPermutations findPermutations = new FindPermutations();
        findPermutations.findPermutations(n);
    }

    public void findPermutations(int n) {
        List<Integer> permutations = new ArrayList<>();
        for (int i = 0;i < n;i++) {
            permutations.add(i + 1);
        }
        allPermutations.add(permutations);

        for (int i = 0;i < permutations.size();i++) {
            Integer removedItem = permutations.get(i);
            List<Integer> newList = new ArrayList<>(permutations.subList(0, i));
            newList.addAll(permutations.subList(i + 1, permutations.size()));

            for (int j = 0;j <= newList.size();j++) {
                newList.add(j, removedItem);
                if (allPermutations.add(newList)) {
                    System.out.println(newList);
                }
                newList.remove(j);
            }
        }
    }
}
