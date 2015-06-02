package com.hakerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class ClosestNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountOfNumber = Integer.parseInt(in.nextLine());
        solution(prepareArray(in.nextLine(), amountOfNumber));
    }

    public static void solution(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0;i < arr.length - 1;i++) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
            }
        }

        for (int i = 0;i < arr.length - 1;i++) {
            if (arr[i + 1] - arr[i] == min) {
                System.out.print(arr[i] + " " + arr[i + 1] + " ");
            }
        }
    }

    public static int[] prepareArray(String input, int size) {
        String[] input_split = input.split(" ");
        int []arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] =  Integer.parseInt(input_split[i]);
        }

        return arr;
    }

}
