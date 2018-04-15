package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        /*
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-10));
        */

        /*
        // -1
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        */

        /*
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(3, 2));
        triangle.add(Arrays.asList(-3, 1, -1));
        */



        System.out.println(minimumTotal(triangle));
    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) {
            return 0;
        }

        for (int i = triangle.size() - 2;i >= 0;i--) {
            for (int j = 0; j <= i; j++) {
                List<Integer> nextRow = triangle.get(i + 1);
                int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }


    /*
    public static int GLOBAL_MIN = Integer.MAX_VALUE;

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            int min = Integer.MAX_VALUE;
            for (Integer column  : triangle.get(0)) {
                if (column < min) {
                    min = column;
                }
            }
            return min;
        }

        List<Integer> firstLevel = triangle.get(0);
        for (int i = 0;i < firstLevel.size();i++) {
            minimumTotalHelper(triangle, 1, i, firstLevel.get(i));
        }
        return GLOBAL_MIN;
    }

    public static int minimumTotalHelper(List<List<Integer>> triangle, int level, int index, int min) {
        if (level >= triangle.size()) {
            return 0;
        }


        int start = index;
        int end = index + 1;
        if (start < 0) {
            start = 0;
        }
        if (end > triangle.size() - 1) {
            end = triangle.size() - 1;
        }
        if (end == start) {
            return triangle.get(level).get(start);
        }

        for (int i = start;i <= end;i++) {
            int currentMin = min + triangle.get(level).get(i) + minimumTotalHelper(triangle, level + 1, i, min + triangle.get(level).get(i));
            if (level == triangle.size() - 1) {
                if (currentMin < GLOBAL_MIN) {
                    GLOBAL_MIN = currentMin;
                }
            }
        }

        return min;
    }
    */
}
