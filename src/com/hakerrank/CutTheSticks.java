package com.hakerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sticks = new int[n];

        for(int i = 0;i < n;i++){
            sticks[i] = in.nextInt();
        }

        Arrays.sort(sticks);
        cutSticks(sticks);
    }

    public static void cutSticks(int []sticks) {
        int index = 0;

        for (;;) {
            System.out.println(sticks.length - index);

            if (index == (sticks.length - 1)) {
                return;
            }

            boolean isFound = false;

            int min = sticks[index];
            for (int i = index; i < sticks.length; i++) {
                if (sticks[i] > min) {
                    index = i;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                break;
            }
        }
    }
}