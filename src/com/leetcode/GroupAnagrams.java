package com.leetcode;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String []strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List value : result) {
            System.out.println(value);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String, List<Integer>> mapping = new HashMap<String, List<Integer>>();

        for (int i = 0; i < strs.length;i++) {
            char []tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String sorted = new String(tmp);
            if (mapping.containsKey(sorted)) {
                List<Integer> indexes = mapping.get(sorted);
                indexes.add(i);
            }
            else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                mapping.put(sorted, indexes);
            }
        }

        for (Map.Entry<String, List<Integer>> mappedGroup : mapping.entrySet()) {
            List<String> group = new ArrayList<>();
            for (int index : mappedGroup.getValue()) {
                group.add(strs[index]);
            }
            groupedAnagrams.add(group);
        }

        return groupedAnagrams;
    }


}
