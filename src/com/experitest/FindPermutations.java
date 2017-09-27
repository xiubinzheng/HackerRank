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
        FindPermutations findPermutations = new FindPermutations();
        //findPermutations.findPermutations(4);

        System.out.println(findPermutations.findPermutations("abc"));
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

    public List<String> findPermutations(String str) {
        if (str == null) {
            return null;
        }

        List<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String reminder = str.substring(1);
        List<String> words = findPermutations(reminder);
        for (String word : words) {
            for (int i = 0;i <= word.length();i++) {
                String s = insertCharAt(word, first, i);
                permutations.add(s);
            }
        }

        return permutations;
    }

    private String insertCharAt(String word, char first, int index) {
        String start = word.substring(0, index);
        String end = word.substring(index);
        return start + first + end;
    }
}
