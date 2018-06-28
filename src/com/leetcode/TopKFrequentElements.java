package com.leetcode;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int []nums = {1,1,1,2,2,3, 4, 4, 4, 4, 4};
        System.out.println(topKFrequent(nums, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapFrequency = new HashMap<>();
        for (int num : nums) {
            mapFrequency.put(num, mapFrequency.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : mapFrequency.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0;i < k;i++) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }
}
