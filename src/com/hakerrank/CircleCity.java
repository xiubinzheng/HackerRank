package com.hakerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class CircleCity {
    public static final Map<Integer, Integer> cachedResult = new HashMap<Integer, Integer>();

    public static class Task {
        public int sqrtRadius;

        public int expectedCountLatticePointsOnCircumference;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountTestCases = Integer.parseInt(in.nextLine());

        for (int i = 0;i < amountTestCases;i++) {
            int arr[] = prepareArray(in.nextLine());
            Task task = new CircleCity.Task();
            task.sqrtRadius = arr[0];
            task.expectedCountLatticePointsOnCircumference = arr[1];

            int result;

            if (cachedResult.containsKey(task.sqrtRadius)) {
                result = cachedResult.get(task.sqrtRadius);
            }
            else {
                result = countLatticePointsOnCircumference(task.sqrtRadius);
                cachedResult.put(task.sqrtRadius, result);
            }

            if (task.expectedCountLatticePointsOnCircumference != result) {
                System.out.println("impossible");
            }
            else {
                System.out.println("possible");
            }
        }
    }

    public static int countLatticePointsOnCircumference(long sqrtRadius) {
        int countLatticePointsOnCircumference = 0;

        double sqrt2 = Math.sqrt(2);
        long xMin = (long)Math.ceil(sqrtRadius / sqrt2);

        for (long x = xMin;x < sqrtRadius;x++) {
            long xx = x * x;
            long yy = sqrtRadius - xx;
            long y = (long) Math.sqrt(yy);
            if (y * y == yy) {
                countLatticePointsOnCircumference++;
            }
        }

        countLatticePointsOnCircumference *= 8;

        return countLatticePointsOnCircumference;
    }

    public static int[] prepareArray(String input) {
        String[] input_split = input.split(" ");
        int []arr = new int[input_split.length];

        for(int i = 0; i < arr.length; i++) {
            arr[i] =  Integer.parseInt(input_split[i]);
        }

        return arr;
    }
}
