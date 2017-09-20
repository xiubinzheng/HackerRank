package com.experitest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anatoly Chernysh
 */
public class PairsOfIndices {

    private static Map<Integer, Integer> calculateMapFrequency(int[] A) {
        // TODO: extra memory, sorting approach can be used, since memory O(N) and performance O(N * Log N)
        final Map<Integer, Integer> mapFrequency = new HashMap<>();
        for (int i = 0;i < A.length;i++) {
            if (mapFrequency.containsKey(A[i])) {
                mapFrequency.put(A[i], mapFrequency.get(A[i]) + 1);
            }
            else {
                mapFrequency.put(A[i], 1);
            }
        }

        return mapFrequency;
    }

    public static int solution(int[] A) {
        int pairsOfIndices = 0;

        final Map<Integer, Integer> mapFrequency = calculateMapFrequency(A);
        for (Map.Entry<Integer, Integer> entry : mapFrequency.entrySet()) {
            int count = entry.getValue();
            // TODO: wrong calculation, should be fixed
            pairsOfIndices += (count * (count - 1)) / 2;
        }

        return pairsOfIndices;
    }

    public static void main(String[] args) {
        int []A = new int[6];
        A[0] = 3;
        A[1] = 5;
        A[2] = 6;
        A[3] = 3;
        A[4] = 3;
        A[5] = 6;

        System.out.println(solution(A));
    }
}
