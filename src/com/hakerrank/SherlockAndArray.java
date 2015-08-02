package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class SherlockAndArray {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int amountOfTestCases = in.nextInt();

        for(int i = 0;i < amountOfTestCases;i++) {
            int length = in.nextInt();

            int []array = new int[length];
            for (int j = 0;j < length;j++) {
                array[j] = in.nextInt();
            }

            System.out.println(findElement(array) ? "YES" : "NO");
        }
    }

    public static boolean findElement(int []arr) {

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        int leftSum = arr[leftIndex];
        int rightSum = arr[rightIndex];

        while (rightIndex != leftIndex) {
            if (leftSum < rightSum) {
                leftIndex++;
                leftSum += arr[leftIndex];
            }
            else {
                rightIndex--;
                rightSum += arr[rightIndex];
            }
        }

        return leftSum == rightSum;
    }
}
