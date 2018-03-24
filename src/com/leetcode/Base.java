package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class Base {

    public static void dump(Integer []data) {
        for (Integer i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void dump(int []data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
