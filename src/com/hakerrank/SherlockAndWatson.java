package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class SherlockAndWatson {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrayToShiftLength = in.nextInt();
        int shiftCount = in.nextInt();
        int amountOfQuestions = in.nextInt();

        int []arrayToShift = new int[arrayToShiftLength];
        for (int i = 0;i < arrayToShiftLength;i++) {
               arrayToShift[i] = in.nextInt();
        }

        cyclicShift(arrayToShift, shiftCount);

        for (int i = 0;i < amountOfQuestions;i++) {
            System.out.println(arrayToShift[in.nextInt()]);
        }
    }

    public static int[] cyclicShift(int []arrayToShift, int shiftCount) {
        for (int i = 0;i < shiftCount;i++) {
            int last = arrayToShift[arrayToShift.length - 1];
            System.arraycopy(arrayToShift, 0, arrayToShift, 1, arrayToShift.length - 1);
            arrayToShift[0] = last;
        }

        return arrayToShift;
    }

    public static void print(int []array) {
        for (int i = 0;i < array.length;i++) {
            System.out.print(array[i] + " ");
        }
    }
}
