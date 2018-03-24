package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> result = generate(7);
        for (List<Integer> line : result) {
            System.out.println(line);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows >= 1) {
            result.add(Arrays.asList(1));
        }
        if (numRows >= 2) {
            result.add(Arrays.asList(1, 1));
        }
        System.out.println("---");

        for (int i = 3;i <= numRows;i++) {
            boolean isEven = i % 2 == 0;
            if (isEven) {
                System.out.println("Even");
                Integer[] prev = result.get(i - 2).subList(0, result.get(i - 2).size() / 2 + 1).toArray(new Integer[0]);

                Integer[]subResult = new Integer[prev.length * 2];
                int curr = 0;
                subResult[curr++] = 1;
                if (prev.length - 1 > 0) {
                    for (int j = 0; j < prev.length - 1; j++) {
                        subResult[curr++] = prev[j] + prev[j + 1];
                    }
                }

                for (int j = subResult.length / 2 - 1;j >= 0;j--) {
                    subResult[curr++] = subResult[j];
                }

                result.add(Arrays.asList(subResult));

            }
            else {
                System.out.println("Odd");
                Integer[] prev = result.get(i - 2).subList(0, result.get(i - 2).size() / 2).toArray(new Integer[0]);

                Integer[]subResult = new Integer[prev.length * 2 + 1];
                int curr = 0;
                subResult[curr++] = 1;
                if (prev.length - 1 > 0) {
                    for (int j = 0; j < prev.length - 1; j++) {
                        subResult[curr++] = prev[j] + prev[j + 1];
                    }
                }
                subResult[curr++] = prev[prev.length - 1] * 2;

                for (int j = subResult.length / 2 - 1;j >= 0;j--) {
                    subResult[curr++] = subResult[j];
                }

                result.add(Arrays.asList(subResult));
            }
        }

        System.out.println("---");
        return result;
    }

    private static void dump(Integer []data) {
        for (Integer i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
