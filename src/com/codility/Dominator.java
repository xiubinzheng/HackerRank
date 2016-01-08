package com.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anatoly Chernysh
 */
public class Dominator {

    public static void main(String[] args) {
        /*
        int A[] = new int[8];
        A[0] = 3;    A[1] = 4;    A[2] =  3;
        A[3] = 2;    A[4] = 3;    A[5] = -1;
        A[6] = 3;    A[7] = 3;
        */
        int A[] = new int[4];
        A[0] = 2;    A[1] = 1;    A[2] =  1;    A[3] =  3;


        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int dominatorSize = A.length / 2;

        int currentMaxDominator = 0;
        int currentMaxDominatorIndex = -1;

        Map<Integer, Integer> dominatorCollector = new HashMap<Integer, Integer>();

        for (int i = 0;i < A.length;i++) {
            if (dominatorCollector.containsKey(A[i])) {
                int value = dominatorCollector.get(A[i]);
                value++;
                dominatorCollector.put(A[i], value);

                if (value > currentMaxDominator) {
                    currentMaxDominator = value;
                    currentMaxDominatorIndex = i;
                }
            }
            else {
                dominatorCollector.put(A[i], 1);
                if (currentMaxDominator < 1) {
                    currentMaxDominator = 1;
                    currentMaxDominatorIndex = i;
                }
            }
        }

        return currentMaxDominator > dominatorSize ? currentMaxDominatorIndex : -1;
    }
}
