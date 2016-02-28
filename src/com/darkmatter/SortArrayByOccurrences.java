package com.darkmatter;

import java.util.*;

/**
 * @author Anatoly Chernysh
 *
 * Given: { 5,5,5,13,6,13,6,7,8,7}
 * Task: Write an algo to arrange this array in sorted form based upon the number of occurrence.
 * Ex: above should look like this after execution of your also {5,5,5,13,13,6,6,7,7,8}
 */
public class SortArrayByOccurrences {

    public static void main(String[] args) {
        int []A = { 5, 5, 5, 13, 6, 13, 6, 7, 8, 7};
        sortByOccurrences(A);
    }

    public static void sortByOccurrences(int A[]) {
        Map<Integer, Integer> occurrencesMap = new HashMap<Integer, Integer>();
        for (int i = 0;i < A.length;i++) {
            if (occurrencesMap.containsKey(A[i])) {
                occurrencesMap.put(A[i], occurrencesMap.get(A[i]) + 1);
            }
            else {
                occurrencesMap.put(A[i], 1);
            }
        }

        TreeMap<Integer, Integer> sortedOccurrences = new TreeMap<>(new ValueComparator(occurrencesMap));
        sortedOccurrences.putAll(occurrencesMap);

        List<Integer> decomposedOccurrences = new ArrayList<>();
        for (int key : sortedOccurrences.keySet()) {
            int value = occurrencesMap.get(key);
            for (int j = 0;j < value;j++) {
                decomposedOccurrences.add(key);
            }
        }
        System.out.println(decomposedOccurrences);
    }
}

class ValueComparator implements Comparator<Integer> {

    public Map<Integer, Integer> occurrencesMap;

    public ValueComparator(Map<Integer, Integer> occurrencesMap) {
        this.occurrencesMap = occurrencesMap;
    }

    @Override
    public int compare(Integer key1, Integer key2) {
        Integer value1 = occurrencesMap.get(key1);
        Integer value2 = occurrencesMap.get(key2);

        int result = value2.compareTo(value1);
        return (result == 0) ? -1 : 1;
    }
}
